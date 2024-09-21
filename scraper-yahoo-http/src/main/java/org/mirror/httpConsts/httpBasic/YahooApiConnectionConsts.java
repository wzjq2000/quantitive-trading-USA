package org.mirror.httpConsts.httpBasic;

public class YahooApiConnectionConsts {
    public static final String GET_CRUMB_URL = "https://query1.finance.yahoo.com/v1/test/getcrumb";

    // make an GET to this url, and retrieve the value of the "set-cookie" from the response header
    public static final String GET_COOKIE_URL = "https://fc.yahoo.com";
}
