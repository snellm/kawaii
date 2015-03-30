package com.snell.michael.kawaii.person;

import com.snell.michael.kawaii.MicroType;

import static com.google.common.base.Preconditions.checkArgument;

public class Age extends MicroType<Integer> {
    public Age(Integer value) {
        super(value);
    }

    @Override
    protected void validate() {
        checkArgument(value >= 0, "Age cannot be negative");
    }
}
