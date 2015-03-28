package com.snell.michael.kawaii;

import java.util.Objects;

public abstract class MicroType<T> {
    private final T value;

    protected MicroType(T value) {
        this.value = Objects.requireNonNull(value);
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
