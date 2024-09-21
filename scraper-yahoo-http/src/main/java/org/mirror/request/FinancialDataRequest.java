package org.mirror.request;

public interface FinancialDataRequest<T> {
    public String getResponseBody();

    public T getResponseBodyAsObject();
}
