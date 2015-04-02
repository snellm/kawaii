package com.snell.michael.kawaii.primitive;

public class BooleanMicroTypes {
    private BooleanMicroTypes() {}

    public static boolean is(BooleanMicroType booleanMicroType) {
        return booleanMicroType.value();
    }
}
