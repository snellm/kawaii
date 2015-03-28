package com.snell.michael.kawaii.person;

import com.snell.michael.kawaii.MicroType;

import static com.google.common.base.Preconditions.checkArgument;

public class Age extends MicroType<Integer> {
    public Age(Integer integer) {
        super(integer);
    }

    @Override
    protected void validate(Integer integer) {
        checkArgument(integer >= 0, "Age cannot be negative");
    }
}
