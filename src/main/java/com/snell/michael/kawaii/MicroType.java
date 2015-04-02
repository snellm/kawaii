package com.snell.michael.kawaii;

/**
 * A microtype wraps a single value of type T to confer specific type identity
 *
 * Implementations of this interface are expected to have a constructor with a single arguement of type T
 *
 * @param <T> Value type
 */
public interface MicroType<T> {
    T value();
}
