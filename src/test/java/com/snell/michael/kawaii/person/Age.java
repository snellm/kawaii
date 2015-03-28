package com.snell.michael.kawaii.person;

import com.snell.michael.kawaii.IntegerMicroType;

import static com.google.common.base.Preconditions.checkArgument;

public class Age extends IntegerMicroType {
    public Age(Integer integer) {
        super(integer);
    }

    @Override
    protected void validate(Integer integer) {
        checkArgument(integer >= 0, "Age cannot be negative");
    }
}
