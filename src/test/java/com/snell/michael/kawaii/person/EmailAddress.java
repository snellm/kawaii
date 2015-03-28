package com.snell.michael.kawaii.person;

import com.google.common.base.Preconditions;
import com.snell.michael.kawaii.MicroType;

public class EmailAddress extends MicroType<String> {
    public EmailAddress(String s) {
        super(s);
    }

    @Override
    protected void validate(String s) {
        super.validate(s);
        Preconditions.checkArgument(s.contains("@"), "Email address must contain @");
    }
}
