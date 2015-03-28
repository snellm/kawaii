package com.snell.michael.kawaii.person;

import com.snell.michael.kawaii.StringMicroType;

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.lang.StringUtils.isBlank;

public abstract class Name extends StringMicroType {
    protected Name(String s) {
        super(s);
    }

    @Override
    protected void validate(String s) {
        super.validate(s);
        checkArgument(!isBlank(s), "Name cannot be blank");
        checkArgument(!s.contains(" "), "Name cannot contain spaces");
    }
}
