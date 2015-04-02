package com.snell.michael.kawaii;

import org.jetbrains.annotations.NotNull;

public abstract class ComparableMicroType<T extends Comparable<T>> extends PrimitiveMicroType<T> implements Comparable<ComparableMicroType<T>> {
    public ComparableMicroType(T value) {
        super(value);
    }

    @Override
    public int compareTo(@NotNull ComparableMicroType<T> o) {
        if (!o.getClass().equals(getClass())) {
            throw new RuntimeException("Cannot compare different types[" + getClass() + "] and [" + o.getClass() + "]");
        } else {
            return value.compareTo(o.value);
        }
    }
}
