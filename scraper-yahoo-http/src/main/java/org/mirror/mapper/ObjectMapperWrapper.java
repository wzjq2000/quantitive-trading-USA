package org.mirror.mapper;


/**
 * We use this wrapper to decouple the third party object mapper from our program.
 * @param <T> ObjectMappers from the third party. Such as the ObjectMapper in Jackson.
 */
public abstract class ObjectMapperWrapper<T> {
    protected T mapper;

    public ObjectMapperWrapper(T mapper) {
        this.mapper = mapper;
    }

    public T getMapper() {
        return mapper;
    }


    /**
     * Map from source to a POJO.
     * @param source The source you want to map from. This could be an input stream, a String or a byte array.
     * @param targetClass The POJO's class
     * @return
     */
    public abstract Object map(Object source, Class<?> targetClass);
}
