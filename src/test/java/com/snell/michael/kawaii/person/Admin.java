package com.snell.michael.kawaii.person;

import com.snell.michael.kawaii.primitive.BooleanMicroType;

public final class Admin extends BooleanMicroType {
    public static final Admin TRUE = new Admin(Boolean.TRUE);
    public static final Admin FALSE = new Admin(Boolean.FALSE);

    public Admin(Boolean value) {
        super(value);
    }

    public static Admin newMicroType(Boolean value) {
        return value ? TRUE : FALSE;
    }
}
