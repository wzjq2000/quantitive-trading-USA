package org.mirror.request;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mirror.DTO.request.QuoteRequest;
import org.mirror.exception.RequestNotInitializedException;

import java.util.Collections;


@Slf4j
public class QuoteRequestTest {
    @Test
    void testGetResponseBodyStringWithoutInit() {
        QuoteRequest qr = new QuoteRequest();
        Assertions.assertThrows(RequestNotInitializedException.class, () -> qr.getResponseBody());

    }

    @Test
    void testGetResponseBodyStringWithInit() {
        QuoteRequest qr = new QuoteRequest();
        qr.init("MSFT","TSLA");
        log.info(qr.getResponseBody());
    }
    @Test
    void testGetResponseEntityWithInit() {
        QuoteRequest qr = new QuoteRequest();
        qr.init("MSFT");
//        log.info(qr.getResponseBodyAsObject().toString());
        assert qr.getResponseBodyAsObject().getQuoteResponse().getResult().get(0).getSymbol().equals("MSFT");
        log.info("finished");
    }


}
