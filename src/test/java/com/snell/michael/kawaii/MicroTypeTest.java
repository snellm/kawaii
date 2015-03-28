package com.snell.michael.kawaii;

import org.junit.Test;

public class MicroTypeTest {
    @Test(expected = RuntimeException.class)
    public void valueCannotBeNull() {
        new TestMicroType(null);
    }
}