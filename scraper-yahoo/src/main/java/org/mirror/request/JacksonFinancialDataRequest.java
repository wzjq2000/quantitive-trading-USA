package org.mirror.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.core5.http.ParseException;
import org.mirror.DTO.quote.QuoteResponseWrapper;
import org.mirror.objectMapperWrapper.manage.ObjectMapperWrapperManager;
import org.mirror.basicDTO.ResponseWrapper;
import org.mirror.mapper.ObjectMapperWrapper;

import java.io.IOException;

/**
 * Using Jackson as the implementation to transform the JSON to POJO. Most {@link FinancialDataRequest} implementations can just extend this class.
 * @param <T> Some class that extends {@link ResponseWrapper}.
 */
public class JacksonFinancialDataRequest<T extends ResponseWrapper> extends AbstractFinancialDataRequest<T> {

    protected ObjectMapperWrapper<ObjectMapper> mapperWrapper = ObjectMapperWrapperManager.getInstance().getJsonObjectMapperWrapper("jackson");

    @Override
    public T getResponseBodyAsObject() {
        checkInit();
        if (responseWrapper != null) {
            return responseWrapper;
        }
        try {
            responseWrapper = (T) holder.makeHttpCallForResponseBody(requestBuilder, (mapperWrapper, inputStream) -> mapperWrapper.map(inputStream, QuoteResponseWrapper.class), mapperWrapper);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return responseWrapper;
    }
}
