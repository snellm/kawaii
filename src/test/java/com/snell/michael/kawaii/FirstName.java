package com.snell.michael.kawaii;

public class FirstName extends StringMicroType {
    protected FirstName(String s) {
        super(s);
    }

    @Override
    protected void validate(String s) {
        super.validate(s);
        if (s.contains(" ")) {
            throw new RuntimeException("First name cannot contain spaces");
        }
    }
}
