package com.snell.michael.kawaii;

import static java.util.Objects.requireNonNull;

/**
 * Wraps a single non-null value and define equality, hashCode and toString by delegation to it
 *
 * @param <T> Type of value wrapped
 */
public abstract class SimpleMicroType<T> implements MicroType<T> {
    protected final T value;

    public SimpleMicroType(T value) {
        this.value = requireNonNull(value);
        validate();
    }

    /**
     * Can be overwritten in subclasses to provide validation on instance creation
     */
    protected void validate() {}

    @Override
    public T value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleMicroType<?> microType = (SimpleMicroType<?>) o;

        return value.equals(microType.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
