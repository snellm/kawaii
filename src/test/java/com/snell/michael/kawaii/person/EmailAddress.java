package com.snell.michael.kawaii.person;

import com.snell.michael.kawaii.StringMicroType;

public class EmailAddress extends StringMicroType {
    protected EmailAddress(String s) {
        super(s);
    }

    @Override
    protected void validate(String s) {
        super.validate(s);
        if (!s.contains("@")) {
            throw new RuntimeException("Email address must contain @");
        }
    }
}
