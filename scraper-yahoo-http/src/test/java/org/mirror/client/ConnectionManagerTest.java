package org.mirror.client;

import lombok.extern.slf4j.Slf4j;
import org.apache.hc.core5.http.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mirror.client.ConnectionManager;
import org.mirror.exception.WrongCookieException;

import java.io.IOException;

@Slf4j
public class ConnectionManagerTest {

    ConnectionManager connectionManager = ConnectionManager.getInstance();
    @Test
    void testGetCookieAndCrumb() throws IOException, ParseException {
        log.info("start...");
        log.info("Cookie: "+connectionManager.getCookie(null));
        log.info("Crumb: "+connectionManager.getCrumb(null));
    }

    @Test
    void testGetCrumb() throws IOException {
        Assertions.assertThrows(WrongCookieException.class,()->connectionManager.getCrumb(null));
    }

}
