package org.mirror.DTO.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.core5.http.ParseException;
import org.mirror.DTO.quote.QuoteResponseWrapper;
import org.mirror.client.HttpClientHolder;
import org.mirror.exception.RequestNotInitializedException;
import org.mirror.request.FinancialDataRequest;

import java.io.IOException;
import java.util.List;

import static org.mirror.httpConsts.YahooApiUrlConsts.BASE_URL;
import static org.mirror.httpConsts.httpBasic.URLConstants.*;

@Slf4j
public class QuoteRequest implements FinancialDataRequest<QuoteResponseWrapper> {
    private HttpClientHolder holder = HttpClientHolder.getInstance();
    private final static String url = BASE_URL + "/v7/finance/quote";

    private String responseBodyString;
    ObjectMapper mapper = new ObjectMapper();

    private HttpClientHolder.HttpRequestBuilder requestBuilder;

    public void init(List<String> symbols) {
        requestBuilder = new HttpClientHolder.HttpRequestBuilder();
        requestBuilder.url(url);
        requestBuilder.urlParam("symbols", String.join(COMMA, symbols));
    }
    public void init(String... symbols) {
        requestBuilder = new HttpClientHolder.HttpRequestBuilder();
        requestBuilder.url(url);
        requestBuilder.urlParam("symbols", String.join(COMMA, symbols));
    }

    @Override
    public String getResponseBody() {
        if (requestBuilder == null) {
            log.error("You are not init yet.");
            throw new RequestNotInitializedException("You are not init yet");
        }
        try {
            responseBodyString = holder.makeHttpCallForResponseBody(requestBuilder);
        } catch (IOException e) {
            log.error("Some IO problem occurred while making request", e);
        } catch (ParseException e) {
            log.error("Some parsing problem occurred while making request", e);
        }

        return responseBodyString;
    }

    @Override
    public QuoteResponseWrapper getResponseBodyAsObject() {
        if(responseBodyString == null) {
            getResponseBody();
        }
        QuoteResponseWrapper quote = null;
        try {
            quote = mapper.readValue(responseBodyString, QuoteResponseWrapper.class);
        } catch (JsonProcessingException e) {
            log.error("Some JSON deserialization problem occurred.", e);
        }
        return quote;
    }
}
