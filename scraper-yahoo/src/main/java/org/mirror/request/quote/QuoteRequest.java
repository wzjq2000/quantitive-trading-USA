package org.mirror.request.quote;

import lombok.extern.slf4j.Slf4j;
import org.mirror.DTO.quote.QuoteResponseWrapper;
import org.mirror.client.HttpClientHolder;
import org.mirror.request.JacksonFinancialDataRequest;

import java.util.List;

import static org.mirror.httpConsts.YahooApiUrlConsts.BASE_URL;
import static org.mirror.httpConsts.httpBasic.URLConstants.*;

@Slf4j
public class QuoteRequest extends JacksonFinancialDataRequest<QuoteResponseWrapper> {
    private final static String url = BASE_URL + "/v7/finance/quote";

    /**
     * Initialize the {@link org.mirror.client.HttpClientHolder.HttpRequestBuilder}. In a word, we need to build the full URL to request. Thus, the user need to pass symbols of financial products to make request to.
     *
     * @param symbols Symbols of financial products to make request to. eg. MSFT
     */
    public void init(String... symbols) {
        if(symbols==null||symbols.length==0) {
            log.error("No symbols specified, init failed");
            return;
        }
        super.init();
        requestBuilder = new HttpClientHolder.HttpRequestBuilder();
        requestBuilder.url(url);
        requestBuilder.urlParam("symbols", String.join(COMMA, symbols));
    }


    /**
     * Similar to {@link QuoteRequest#init(String...)}.
     *
     * @param symbols Symbols of financial products to make request to.
     */
    public void init(List<String> symbols) {
        if(symbols==null||symbols.isEmpty()) {
            log.error("No symbols specified, init failed");
            return;
        }
        super.init();
        requestBuilder.url(url);
        requestBuilder.urlParam("symbols", String.join(COMMA, symbols));
    }
}
