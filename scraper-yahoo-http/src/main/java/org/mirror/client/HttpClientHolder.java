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
import util.StringUtils;

import java.io.IOException;
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


    public static String makeHttpCallForResponseBody(String httpClientKey, HttpRequestBuilder builder) throws IOException, ParseException {
        CloseableHttpClient httpClient = getHttpClient(httpClientKey);
        if (httpClient == null || StringUtils.isEmpty(httpClientKey) || httpClientKey.equals("default")) {
            log.info("Making http call using default client.");
            httpClient = DEFAULT;
        }


        HttpUriRequest request = builder.build();

        String respBody = null;
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            respBody = EntityUtils.toString(response.getEntity());
        } catch (ParseException e) {
            log.error("Error getting response body!", e);
        } catch (IOException e) {
            log.error("Error getting response body!", e);
        }
        return respBody;
    }

    public static String makeHttpCallForResponseBody(HttpRequestBuilder builder) throws IOException, ParseException {
        return makeHttpCallForResponseBody(null, builder);
    }


    public static class HttpRequestBuilder {
        private String url;
        private Map<String, String> urlParam = new HashMap<>();
        private String method;
        private String body;
        private Map<String, String> headers= new HashMap<>();


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

            // Automatically adding cookie, crumb and user agent to the request (if not provided by user).
            headers.putIfAbsent("User-Agent", UserAgent.DEFAULT_AGENT);
            headers.putIfAbsent("Cookie", ConnectionManager.getInstance().getCookie(null));

            String newURL = url;
            if (urlParam != null) {
                if (!urlParam.containsKey("crumb")) {
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

    }

}
