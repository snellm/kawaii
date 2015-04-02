package com.snell.michael.kawaii;

/**
 * A microtype wraps a single value of type T to confer specific type identity
 *
 * @param <T> Value type
 */
public interface MicroType<T> {
    T value();
}
