package com.snell.michael.kawaii;

import static java.util.Objects.requireNonNull;

public abstract class NotNullMicroType<T> extends ValidateableMicroType<T> {
    protected NotNullMicroType(T t) {
        super(t);
    }

    @Override
    protected void validate(T t) {
        super.validate(t);
        requireNonNull(t);
    }
}
