package org.mirror.request.quote;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mirror.DTO.quote.QuoteResponseWrapper;
import org.mirror.exception.RequestNotInitializedException;


@Slf4j
public class QuoteRequestTest {
    @Test
    void testGetResponseBodyAsObjectWithoutInit() {
        QuoteRequest qr = new QuoteRequest();
        Assertions.assertThrows(RequestNotInitializedException.class, () -> qr.getResponseBodyAsObject(QuoteResponseWrapper.class));

    }

    @Test
    void testGetResponseBodyStringWithInit() {
        QuoteRequest qr = new QuoteRequest();
        qr.init("MSFT","TSLA");
        log.info(qr.getResponseBodyString());
    }
    @Test
    void testGetResponseEntityWithInit() {
        QuoteRequest qr = new QuoteRequest();
        qr.init("MSFT");
        assert qr.getResponseBodyAsObject(QuoteResponseWrapper.class).getQuoteResponse().getResult().get(0).getSymbol().equals("MSFT");
        log.info("finished");
    }


}
