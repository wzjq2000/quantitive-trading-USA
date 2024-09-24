package org.mirror.client;

import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.mirror.exception.WrongUrlException;
import org.mirror.httpConsts.httpBasic.URLConstants;
import org.mirror.httpConsts.httpBasic.UserAgent;
import org.mirror.mapper.JsonInputStreamToObject;
import org.mirror.mapper.ObjectMapperWrapper;
import util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Holder for client for making http call
 */
@Slf4j
public class HttpClientHolder {
    private static volatile ConcurrentHashMap<String, CloseableHttpClient> map = new ConcurrentHashMap<>();
    private static volatile CloseableHttpClient DEFAULT = HttpClients.createDefault();
    private static final ConnectionManager CONNECTION_MANAGER = ConnectionManager.getInstance();
    private static final HttpClientHolder INSTANCE = new HttpClientHolder();

    private HttpClientHolder() {
    }

    public synchronized static HttpClientHolder getInstance() {
        return INSTANCE;
    }

    private static CloseableHttpClient getHttpClient(String httpClientKey) {
        if (StringUtils.isEmpty(httpClientKey) || httpClientKey.equals("default")) {
            log.info("Making http call using default client.");
            return DEFAULT;
        }
        CloseableHttpClient httpClient = map.get(httpClientKey);
        return httpClient;
    }

    public static CloseableHttpClient getHttpClient() {
        return DEFAULT;
    }

    //TODO: 根据setting来构建HttpClient
    public static CloseableHttpClient buildHttpClient(String httpClientKey, HttpClientSetting setting) {
        return null;
    }

    public static void destroyHttpClient(String httpClientKey) throws IOException {
        if (StringUtils.isEmpty(httpClientKey) || httpClientKey.equals("default")) {
            destroyDefaultHttpClient();

        }
        CloseableHttpClient httpClient = getHttpClient(httpClientKey);
        if (httpClient != null) {
            httpClient.close();
            map.remove(httpClientKey);
        }
    }

    public static void destroyDefaultHttpClient() throws IOException {
        DEFAULT.close();
        DEFAULT = null;
    }


    public static String makeHttpCallForResponseBodyString(String httpClientKey, HttpRequestBuilder builder) throws IOException, ParseException {
        CloseableHttpClient httpClient = getHttpClient(httpClientKey);

        HttpUriRequest request = builder.build();

        String respBody = null;
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            int statusCode = response.getCode();
            if (statusCode == 200) {
                respBody = EntityUtils.toString(response.getEntity());
            } else {
                log.error("Failed to get response, the status code is {}", statusCode);
            }
        } catch (ParseException e) {
            log.error("Error getting response body!", e);
        } catch (IOException e) {
            log.error("Error getting response body!", e);
        }
        return respBody;
    }

    public static String makeHttpCallForResponseBodyString(HttpRequestBuilder builder) throws IOException, ParseException {
        return makeHttpCallForResponseBodyString(null, builder);
    }


    public static Object makeHttpCallForResponseBody(HttpRequestBuilder builder, JsonInputStreamToObject func, ObjectMapperWrapper mapperWrapper) throws IOException, ParseException {
        return makeHttpCallForResponseBody(null, builder, func, mapperWrapper);
    }

    public static Object makeHttpCallForResponseBody(String httpClientKey, HttpRequestBuilder builder, JsonInputStreamToObject func, ObjectMapperWrapper mapperWrapper) throws IOException, ParseException {
        CloseableHttpClient httpClient = getHttpClient(httpClientKey);


        HttpUriRequest request = builder.build();
        Object respBody = null;

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            int statusCode = response.getCode();
            if (statusCode == 200) {
                InputStream content = response.getEntity().getContent();
                respBody = func.convert(mapperWrapper, content);
            } else {
                log.error("Failed to get response, the status code is {}", statusCode);
            }
        } catch (IOException e) {
            log.error("Error getting response body!", e);
        }
        return respBody;
    }


    /**
     * A builder to build HttpUriRequest that can be directly used to make http call.
     */
    public static class HttpRequestBuilder {
        private String url;
        private Map<String, String> urlParam = new HashMap<>();
        private String method;
        private String body;
        private Map<String, String> headers = new HashMap<>();


        public HttpRequestBuilder() {
        }

        public HttpRequestBuilder urlParam(String key, String value) {
            urlParam.put(key, value);
            return this;
        }

        public HttpRequestBuilder urlParam(Map<String, String> params) {
            urlParam.putAll(params);
            return this;
        }

        public HttpRequestBuilder url(String url) {
            this.url = url;
            return this;
        }

        public HttpRequestBuilder header(String key, String value) {
            this.headers.put(key, value);
            return this;
        }

        public HttpRequestBuilder headers(Map<String, String> headers) {
            this.headers.putAll(headers);
            return this;
        }

        public HttpRequestBuilder method(String method) {
            this.method = method;
            return this;
        }

        public HttpRequestBuilder body(String body) {
            this.body = body;
            return this;
        }


        /**
         * Building a http request object. This object has been added the essential elements to make the valid call such as cookie, user agent and crumb. Be aware that if the user does not provide cookie and crumb, we will get them from the {@link ConnectionManager}. This will cause another two http calls if the ConnectionManager does not contain valid cookie and crumb.
         *
         * @return HttpUriRequest that can be executed directly.
         * @throws IOException
         * @throws ParseException
         */
        HttpUriRequest build() throws IOException, ParseException {
            if (StringUtils.isEmpty(url)) {
                log.error("Request url is empty");
                throw new WrongUrlException("Request url is empty");
            }
            while (url.endsWith(URLConstants.QUESTION) || url.endsWith(URLConstants.SLASH)) {
                log.debug("Removing \"/\" and \"?\" in the end of url.");
                url = url.substring(0, url.length() - 1);
            }
            if (StringUtils.isEmpty(method)) {
                log.info("Request method is empty, thus we will use GET method by default.");
                method = "GET";
            }

            // Automatically adding cookie, and user agent to the request (if not provided by user). PS: We will make a http call to get the cookie if the ConnectionManager does not contain a valid cookie.
            headers.putIfAbsent("User-Agent", UserAgent.DEFAULT_AGENT);

            // FIXME: We can not ensure that cookie!=null here, we need to fail immediately if cookie is null.
            headers.putIfAbsent("Cookie", ConnectionManager.getInstance().getCookie(null));

            // Concatenate the params to url. PS: if the user don't pass the crumb param, we will do it for you. Thus, we will make a http call to get the crumb if the ConnectionManager does not contain a valid cookie.
            String newURL = concatParamsToUrl();

            HttpUriRequest request = null;
            if (method.equals("GET")) {
                request = new HttpGet(newURL);
            } else if (method.equals("POST")) {
                request = new HttpPost(newURL);
                // TODO: what to do with the request body?
            }

            for (Map.Entry<String, String> entry : headers.entrySet()) {
                request.addHeader(entry.getKey(), entry.getValue());
            }

            log.info("Request URL: [" + newURL + "], with header: [" + headers + "]");


            return request;
        }

        private String concatParamsToUrl() throws ParseException, IOException {
            String newURL = url;
            if (urlParam != null) {
                if (!urlParam.containsKey("crumb")) {
                    // FIXME: We can not ensure that crumb!=null here
                    urlParam.put("crumb", ConnectionManager.getInstance().getCrumb(null));
                }
                StringBuilder sb = new StringBuilder(url);
                sb.append(URLConstants.QUESTION);
                int c = urlParam.size();
                for (Map.Entry<String, String> entry : urlParam.entrySet()) {
                    c--;
                    sb.append(entry.getKey()).append(URLConstants.EQUAL).append(entry.getValue());
                    if (c > 0) {
                        sb.append("&");
                    }
                }
                newURL = sb.toString();
            }
            return newURL;
        }
    }


}
