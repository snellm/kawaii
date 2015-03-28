package com.snell.michael.kawaii.person;

import com.google.common.base.Preconditions;
import com.snell.michael.kawaii.StringMicroType;

public class EmailAddress extends StringMicroType {
    public EmailAddress(String s) {
        super(s);
    }

    @Override
    protected void validate(String s) {
        super.validate(s);
        Preconditions.checkArgument(s.contains("@"), "Email address must contain @");
    }
}
