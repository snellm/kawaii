package com.snell.michael.kawaii.person;

import com.snell.michael.kawaii.MicroType;

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.lang.StringUtils.isBlank;

public abstract class Name extends MicroType<String> {
    protected Name(String value) {
        super(value);
    }

    @Override
    protected void validate() {
        super.validate();
        checkArgument(!isBlank(value), "Name cannot be blank");
        checkArgument(!value.contains(" "), "Name cannot contain spaces");
    }
}
