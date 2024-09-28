package org.mirror.objectMapperWrapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import lombok.extern.slf4j.Slf4j;
import org.mirror.mapper.ObjectMapperWrapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * An {@link ObjectMapperWrapper} that is implemented using Jackson. We use this mapper wrapper to map from JSON to a POJO.
 */
@Slf4j
public class JacksonObjectMapperWrapper extends ObjectMapperWrapper<ObjectMapper> {
    public JacksonObjectMapperWrapper(ObjectMapper mapper) {
        super(mapper);
        customizeObjectMapper(mapper);
    }

    /**
     * We don't want the program to throw the exception and stop running during deserialization. Instead, we hope it to skip the problematic property and go on. Thus, we need to customize the ObjectMapper.
     */
    private void customizeObjectMapper(ObjectMapper mapper) {

        mapper.addHandler(new DeserializationProblemHandler() {
            @Override
            public boolean handleUnknownProperty(DeserializationContext ctxt, JsonParser p, JsonDeserializer<?> deserializer, Object beanOrClass, String propertyName) throws IOException {
                log.warn("Problems encountered during Jackson deserialization. Unknown property '{}' of type '{}'. Skip this property.", propertyName, beanOrClass);
                p.skipChildren();
                return false;
            }
        });

        // make the handler we define above valid
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    }

    @Override
    public Object map(Object source, Class<?> targetClass) {
        Object result = null;
        if (source instanceof InputStream) {
            try {
                result = this.mapper.readValue((InputStream) source, targetClass);
            } catch (IOException e) {
                log.error("Problem parsing JSON input stream", e);
                throw new RuntimeException(e);
            }
        } else if (source instanceof String) {
            try {
                result = this.mapper.readValue((String) source, targetClass);
            } catch (JsonProcessingException e) {
                log.error("Problem parsing JSON", e);
                throw new RuntimeException(e);
            }
        } else if (source instanceof byte[]) {
            try {
                result = this.mapper.readValue((byte[]) source, targetClass);
            } catch (IOException e) {
                log.error("Problem parsing JSON byte array", e);
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}
