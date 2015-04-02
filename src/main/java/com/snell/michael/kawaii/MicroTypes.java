package com.snell.michael.kawaii;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

/**
 * Utility methods for MicroTypes
 */
// TODO Add caching for reflective newMicroType and constructor lookup?
public class MicroTypes {
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
        try {
            Method method = clazz.getMethod("newMicroType", value.getClass());
            try {
                //noinspection unchecked
                return (M) method.invoke(null, value);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException("getInstance method exists but failed on [" + clazz + "]", e);
            }
        } catch (NoSuchMethodException e) {
            try {
                return clazz.getDeclaredConstructor(value.getClass()).newInstance(value);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException f) {
                throw new RuntimeException("Unable to create new instance of [" + clazz + "] with value [" + value + "]", f);
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
}
