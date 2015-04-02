package com.snell.michael.kawaii.primitive;

// TODO Should this exist, or should enums be used for boolean microtypes?
public abstract class BooleanMicroType extends PrimitiveMicroType<Boolean> {
    public BooleanMicroType(Boolean value) {
        super(value);
    }
}
