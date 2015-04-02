package com.snell.michael.kawaii.person;

import com.snell.michael.kawaii.string.StringMicroType;

import static com.google.common.base.Preconditions.checkArgument;

public class EmailAddress extends StringMicroType {
    public EmailAddress(String value) {
        super(value);
    }

    @Override
    protected void validate() {
        super.validate();
        checkArgument(value.contains("@"), "Email address must contain @");
    }
}
