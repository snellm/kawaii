package com.snell.michael.kawaii.person;

import com.snell.michael.kawaii.StringMicroType;

import static org.apache.commons.lang.StringUtils.isBlank;

public class Name extends StringMicroType {
    protected Name(String s) {
        super(s);
    }

    @Override
    protected void validate(String s) {
        super.validate(s);
        if (isBlank(s)) {
            throw new RuntimeException("Name cannot be blank");
        }

        if (s.contains(" ")) {
            throw new RuntimeException("Name cannot contain spaces");
        }
    }
}
