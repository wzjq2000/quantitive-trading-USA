package org.mirror.client;

import lombok.Getter;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.mirror.exception.WrongCookieException;
import org.mirror.httpConsts.httpBasic.UserAgent;
import org.mirror.httpConsts.YahooApiConnectionConsts;
import lombok.extern.slf4j.Slf4j;
import util.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * This class is for some essential preparations before getting financial data from yahoo. This class is responsible for:
 * 1. Getting cookie for later call.
 * 2. Getting crumb for later call. Before getting crumb, you must get cookie first.
 */
@Slf4j
@Getter
public class ConnectionManager {
    private volatile String cookie;
    private volatile String crumb;

    /**
     * timestamp of getting the cookie. We assume the cookie is valid for {@link ConnectionManager#validDuration}. Actually, according to my test, the cookie can last for a very long time.
     */
    private long getCookieTime;

    /**
     * We assume the cookie can be valid for 24hrs(=86400000ms).
     */
    private long validDuration = 86400000;

    /**
     * We allow there is 1 second delay between getting cookie and getting crumb.
     */
    private long defaultDelay = 1000;

    private final CloseableHttpClient client;

    /**
     * We use requestCookieTimes and requestCrumbTimes to ensure crumb is always requested with the current cookie.
     */
    private volatile int requestCookieTimes;
    private volatile int requestCrumbTimes;

    /**
     * cookieLock and crumbLock are used to make sure that only one request will be made in the situation of concurrency.
     */
    public Lock cookieLock = new ReentrantLock();
    public Lock crumbLock = new ReentrantLock();


    private final static ConnectionManager INSTANCE = new ConnectionManager();

    private ConnectionManager() {
        this.client = HttpClientHolder.getHttpClient();
    }

    public static ConnectionManager getInstance() {
        boolean ifSuccess = false;
        try {
            ifSuccess = INSTANCE.init();
        } catch (IOException e) {
            log.error("Failed to initialize ConnectionManager, because the obtaining valid Cookie or crumb failed", e);
            throw new RuntimeException(e);
        } catch (ParseException e) {
            log.error("Failed to initialize ConnectionManager, because the obtaining valid Cookie or crumb failed", e);
            throw new RuntimeException(e);
        }
        if (ifSuccess) {
            return INSTANCE;
        } else {
            log.error("Failed to initialize ConnectionManager, because the obtaining valid Cookie or crumb failed");
            throw new WrongCookieException("Failed to initialize ConnectionManager, because the obtaining valid Cookie or crumb failed");
        }
    }

    public boolean init() throws IOException, ParseException {
        INSTANCE.getCookie(null);
        INSTANCE.getCrumb(null);
        if (ifCookieAndCrumbValid()) return true;
        return false;
    }


    public boolean ifCookieAndCrumbValid() {
        return ifCookieValid() && !StringUtils.isEmpty(crumb);
    }

    /**
     * Make http request for getting the crumb.
     * Before calling the method, you must ensure calling {@link ConnectionManager#getCookie(Map)} first.
     *
     * @param headers if you want to add some headers to the request, you can pass this map. Adding a "User-Agent" header is strongly recommended!! PS: Even if the map contains "Cookie", it will not override the cookie in this object.
     * @return crumb
     */
    String getCrumb(Map<String, String> headers) throws ParseException, IOException {
        if (ifCookieValid(defaultDelay)) {
            if (crumb != null && requestCookieTimes == requestCrumbTimes) {
                return crumb;
            } else {
                // Instead of using the provided cookie(if exists), we use the cookie that is requested by {@link #getCookie(Map<String, String>)}.
                // We also add the user agent if it is not provided.
                if (headers != null) {
                    headers.put("Cookie", cookie);
                    if (!headers.containsKey("User-Agent")) {
                        headers.put("User-Agent", UserAgent.DEFAULT_AGENT);
                    }
                } else {
                    headers = new HashMap<>();
                    headers.put("Cookie", cookie);
                    headers.put("User-Agent", UserAgent.DEFAULT_AGENT);
                }
                HttpGet httpGet = new HttpGet(YahooApiConnectionConsts.GET_CRUMB_URL);
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    httpGet.setHeader(header.getKey(), header.getValue());
                }

                if (crumb != null && requestCookieTimes == requestCrumbTimes) {
                    return crumb;
                }

                try {
                    crumbLock.lock();
                    if (crumb != null && requestCookieTimes == requestCrumbTimes) {
                        return crumb;
                    }
                    log.info("Crumb not existing, so we try to request the crumb...");
                    try (CloseableHttpResponse response = client.execute(httpGet)) {
                        if (response.getCode() == 200) {
                            crumb = EntityUtils.toString(response.getEntity());
                            // TODO: Is there a way to validate if the crumb is valid?
                            requestCrumbTimes = requestCookieTimes;
                        }
                    } catch (ParseException e) {
                        log.error("Error getting crumb!", e);
                        throw e;
                    } catch (IOException e) {
                        log.error("Error getting crumb!", e);
                        throw e;
                    }

                } finally {
                    crumbLock.unlock();
                }


                return crumb;
            }
        } else {
            log.error("You must first get the valid cookie to get the crumb! Please call getCookie(...) first!");
            throw new WrongCookieException("You must first get the valid cookie to get the crumb! Please call getCookie(...) first!");
        }


    }


    /**
     * Make http request for getting the cookie
     *
     * @param headers if you want to add some headers to the request, you can pass this map. Adding a "User-Agent" header is strongly recommended!!
     * @return Cookie
     */
    String getCookie(Map<String, String> headers) throws IOException {
        if (ifCookieValid()) {
            return cookie;
        }


        // In order to get the cookie, the header must not contain cookie.
        // We also add the user agent if it is not provided.
        if (headers != null) {
            headers.remove("Cookie");
            if (!headers.containsKey("User-Agent")) {
                headers.put("User-Agent", UserAgent.DEFAULT_AGENT);
            }
        } else {
            // only add essential headers for getting the cookie
            headers = new HashMap<>();
            headers.put("User-Agent", UserAgent.DEFAULT_AGENT);
        }
        HttpGet httpGet = new HttpGet(YahooApiConnectionConsts.GET_COOKIE_URL);
        for (Map.Entry<String, String> header : headers.entrySet()) {
            httpGet.setHeader(header.getKey(), header.getValue());
        }
        try {
            if (ifCookieValid()) return cookie;
            cookieLock.lock();
            if (ifCookieValid()) return cookie;
            log.info("Cookie not existing, so we try to request the Cookie...");

            try (CloseableHttpResponse response = client.execute(httpGet)) {
                cookie = response.getFirstHeader("Set-Cookie").getValue();
                if (cookie == null) {
                    log.warn("Did not get the cookie!");
                } else {
                    requestCookieTimes++;
                    getCookieTime = System.currentTimeMillis();
                }
            } catch (IOException e) {
                log.error("Error getting cookie!", e);
                throw e;
            }
        } finally {
            cookieLock.unlock();
        }

        return cookie;
    }

    public boolean ifCookieValid() {
        if (cookie == null || System.currentTimeMillis() - getCookieTime >= validDuration) {
            return false;
        }
        return true;
    }

    public boolean ifCookieValid(long defaultDelay) {
        if (cookie == null || System.currentTimeMillis() + defaultDelay - getCookieTime >= validDuration) {
            return false;
        }
        return true;
    }


    public void setDefaultDelay(long defaultDelay) {
        this.defaultDelay = defaultDelay;
    }

}
