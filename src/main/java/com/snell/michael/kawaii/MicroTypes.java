package com.snell.michael.kawaii;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Utility methods for MicroTypes
 */
public class MicroTypes {
    private static final Map<Class<? extends MicroType>, Constructor<? extends MicroType>> CONSTRUCTOR_CACHE = new ConcurrentHashMap<>();
    private static final Map<Class<? extends MicroType>, Optional<Method>> NEWMICROTYPE_METHOD_CACHE = new ConcurrentHashMap<>();

    private MicroTypes() {}

    /**
     * Create a new microtype instance of the given class with the given value. Will throw a runtime exception if value
     * is null. Will never return null.
     *
     * @param clazz Class of microtype to create
     * @param value Value
     * @param <M> Microtype type
     * @param <T> Value type
     * @return A newly created instance of the microtype
     */
    public static <M extends MicroType<T>, T> M newMicroType(Class<M> clazz, T value) {
        Optional<Method> newMicroTypeMethod = getNewMicroTypeMethod(clazz, value);

        if (newMicroTypeMethod.isPresent()) {
            try {
                //noinspection unchecked
                return (M) newMicroTypeMethod.get().invoke(null, value);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException("getInstance method exists but failed on [" + clazz + "] with value [" + value + "]", e);
            }
        } else {
            try {
                return getConstructor(clazz, value).newInstance(value);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException f) {
                throw new RuntimeException("Unable to create new instance of [" + clazz + "] with value [" + value + "] via constructor", f);
            }
        }
    }

    /**
     * Creates a new microtype of the same type as the given microType, but with a new value
     *
     * @param microType Microtype to clone
     * @param value New value
     * @param <M> Microtype type
     * @param <T> Value type
     * @return A newly created instance of the microtype
     */
    @SuppressWarnings("unchecked")
    public static <M extends MicroType<T>, T> M newMicroType(M microType, T value) {
        return (M) newMicroType(microType.getClass(), value);
    }

    /**
     * Create a new microtype instance of the given class with the given value. Will return null if value is null.
     *
     * @param clazz Class of microtype to create
     * @param value Value
     * @param <M> Microtype type
     * @param <T> Value type
     * @return A newly created instance of the microtype
     */
    public static <M extends MicroType<T>, T> M newNullableMicroType(Class<M> clazz, T value) {
        if (value == null) {
            return null;
        } else {
            return newMicroType(clazz, value);
        }
    }

    /**
     * Create a new optional microtype instance of the given class with the given value. Will return
     * Optional.empty if value is null
     *
     * @param clazz Class of microtype to create
     * @param value Value
     * @param <M> Microtype type
     * @param <T> Value type
     * @return A newly created instance of the microtype
     */
    public static <M extends MicroType<T>, T> Optional<M> newOptionalMicroType(Class<M> clazz, T value) {
        if (value == null) {
            return Optional.empty();
        } else {
            return Optional.of(newMicroType(clazz, value));
        }
    }

    private static <M extends MicroType<T>, T> Optional<Method> getNewMicroTypeMethod(Class<M> clazz, T value) {
        Optional<Method> method = NEWMICROTYPE_METHOD_CACHE.get(clazz);
        if (method == null) {
            try {
                method = Optional.of(clazz.getMethod("newMicroType", value.getClass()));
            } catch (NoSuchMethodException e) {
                method = Optional.empty();
            }
            NEWMICROTYPE_METHOD_CACHE.put(clazz, method);
        }
        return method;
    }

    private static <M extends MicroType<T>, T> Constructor<M> getConstructor(Class<M> clazz, T value) {
        try {
            //noinspection unchecked
            Constructor<M> constructor = (Constructor<M>) CONSTRUCTOR_CACHE.get(clazz);
            if (constructor == null) {
                constructor = clazz.getDeclaredConstructor(value.getClass());
                CONSTRUCTOR_CACHE.put(clazz, constructor);
            }
            return constructor;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("No suitable constructor for [" + clazz + "] with value [" + value + "]", e);
        }
    }
}
