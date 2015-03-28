package com.snell.michael.kawaii;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

public class MicroTypes {
    private MicroTypes() {}

    public static <M extends MicroType<T>, T> M instance(Class<M> clazz, T t) {
        try {
            return clazz.getDeclaredConstructor(t.getClass()).newInstance(t);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException("Unable to create nullableInstance nullableInstance [" + clazz + "] with value [" + t + "]", e);
        }
    }

    public static <M extends MicroType<T>, T> M nullableInstance(Class<M> clazz, T t) {
        if (t == null) {
            return null;
        } else {
            return instance(clazz, t);
        }
    }

    public static <M extends MicroType<T>, T> Optional<M> optionalInstance(Class<M> clazz, T t) {
        if (t == null) {
            return Optional.empty();
        } else {
            return Optional.of(instance(clazz, t));
        }
    }
}
