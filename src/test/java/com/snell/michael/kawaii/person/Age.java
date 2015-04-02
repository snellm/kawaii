package com.snell.michael.kawaii.person;

import com.snell.michael.kawaii.primitive.IntegerMicroType;

import static com.google.common.base.Preconditions.checkArgument;

public class Age extends IntegerMicroType {
    public Age(Integer value) {
        super(value);
    }

    @Override
    protected void validate() {
        checkArgument(value >= 0, "Age cannot be negative");
    }
}
