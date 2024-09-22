package org.mirror.basicDTO;

/**
 * Most of the time, when we request Yahoo finance api, we will often get a JSON string like {"xxxResponse":{...}}. Thus, here we define a wrapper according to the outer "{}"
 * @param <T> The inner response.
 */
public class ResponseWrapper<T> {
}
