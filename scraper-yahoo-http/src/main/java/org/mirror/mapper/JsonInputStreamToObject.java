package org.mirror.mapper;


import java.io.IOException;
import java.io.InputStream;

/**
 * Map from an JSON input stream to a POJO.
 * @param <T> The POJO you want to map to.
 */
@FunctionalInterface
public interface JsonInputStreamToObject<T> {
    T convert(ObjectMapperWrapper mapperWrapper, InputStream inputStream) throws IOException;
}
