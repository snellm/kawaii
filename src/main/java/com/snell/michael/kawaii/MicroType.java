package com.snell.michael.kawaii;

import static java.util.Objects.requireNonNull;

/**
 * Wraps a single non-null primitive value to confer specific type identity
 *
 * @param <T> Type of value wrapped
 */
public abstract class MicroType<T> {
    protected final T value;

    protected MicroType(T value) {
        this.value = requireNonNull(value);
        validate();
    }

    /**
     * Can be overwritten in subclasses to provide validation on instance creation
     */
    protected void validate() {}

    public T value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MicroType<?> microType = (MicroType<?>) o;

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
