package com.snell.michael.kawaii;

import java.lang.reflect.InvocationTargetException;

public class MicroTypes {
    private MicroTypes() {}

    public static <M extends MicroType<T>, T> M instance(Class<M> clazz, T t) {
        // TODO If there is a returnNull method, call it and return null if true
        // clazz.getMethod("");

        // TODO If there is a validate method, call it, rethrowing runtime exception if neccesary
//        Method validateMethod = Arrays.asList(clazz.getMethods()).stream()
//                .filter(method -> "validate".equals(method.getName())).findFirst().get();
//        validateMethod.invoke()

        try {
            return (M) clazz.getDeclaredConstructors()[0].newInstance(t);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Unable to create instance of [" + clazz + "] with value [" + t + "]", e);
        }
    }
}
