package org.mirror.request;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mirror.exception.RequestNotInitializedException;


@Slf4j
public class QuoteRequestTest {
    @Test
    void testGetResponseBodyAsObjectWithoutInit() {
        QuoteRequest qr = new QuoteRequest();
        Assertions.assertThrows(RequestNotInitializedException.class, () -> qr.getResponseBodyAsObject());

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
        assert qr.getResponseBodyAsObject().getQuoteResponse().getResult().get(0).getSymbol().equals("MSFT");
        log.info("finished");
    }


}
