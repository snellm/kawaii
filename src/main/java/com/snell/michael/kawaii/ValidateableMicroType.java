package com.snell.michael.kawaii;

public abstract class ValidateableMicroType<T> extends MicroType<T> {
    protected ValidateableMicroType(T t) {
        super(t);
        validate(t);
    }

    protected void validate(T t) {}
}
