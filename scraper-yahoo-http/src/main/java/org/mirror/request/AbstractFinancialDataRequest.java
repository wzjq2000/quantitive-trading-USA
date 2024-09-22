package org.mirror.request;

import lombok.extern.slf4j.Slf4j;
import org.apache.hc.core5.http.ParseException;
import org.mirror.basicDTO.ResponseWrapper;
import org.mirror.client.HttpClientHolder;
import org.mirror.exception.RequestNotInitializedException;

import java.io.IOException;

/**
 * This abstract class has the ability to get the response in String.
 * @param <T>
 */
@Slf4j
public abstract class AbstractFinancialDataRequest<T extends ResponseWrapper> implements FinancialDataRequest<T> {
    protected HttpClientHolder holder = HttpClientHolder.getInstance();

    protected T responseWrapper = null;

    protected
    HttpClientHolder.HttpRequestBuilder requestBuilder;


    public void init() {
        requestBuilder = new HttpClientHolder.HttpRequestBuilder();
    }



    public void checkInit() {
        if (requestBuilder == null) {
            log.error("You are not init yet.");
            throw new RequestNotInitializedException("You are not init yet");
        }
    }

    @Override
    public String getResponseBodyString() {
        checkInit();
        String responseBodyString = null;

        try {
            responseBodyString = holder.makeHttpCallForResponseBodyString(requestBuilder);
        } catch (IOException e) {
            log.error("Some IO problem occurred while making request", e);
        } catch (ParseException e) {
            log.error("Some parsing problem occurred while making request", e);
        }

        return responseBodyString;
    }


}
