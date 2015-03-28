package com.snell.michael.kawaii.person;

import com.snell.michael.kawaii.IntegerMicroType;

public class Age extends IntegerMicroType {
    protected Age(Integer integer) {
        super(integer);
    }

    @Override
    protected void validate(Integer integer) {
        if (integer < 0) {
            throw new RuntimeException("Age cannot be negative");
        }
    }
}
