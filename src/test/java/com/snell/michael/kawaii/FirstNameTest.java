package com.snell.michael.kawaii;

import org.junit.Test;

public class FirstNameTest {
    @Test
    public void instance() {
        MicroTypes.instance(FirstName.class, "Michael");
    }

    @Test(expected = RuntimeException.class)
    public void validation() {
        MicroTypes.instance(FirstName.class, "Foo Bar");
    }
}