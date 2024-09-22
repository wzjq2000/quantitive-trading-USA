package org.mirror.request;

import org.mirror.basicDTO.ResponseWrapper;

/**
 * A request object that can be used to get ResponseBody.
 * @param <T> The response body's POJO.
 */
public interface FinancialDataRequest<T extends ResponseWrapper> {

    default String getResponseBodyString(){
        throw new UnsupportedOperationException("Please implement getResponseBodyString() method. Be aware that there is a default implementation in AbstractFinancialDataRequest. Maybe you can use that.");
    }

    /**
     * Turning the response into an Object may be dependent on the concrete implementation.
     * @return The POJO that is turned from a response body.
     */
    T getResponseBodyAsObject();
}
