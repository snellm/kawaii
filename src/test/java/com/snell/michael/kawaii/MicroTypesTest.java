package com.snell.michael.kawaii;

import org.junit.Test;

public class MicroTypesTest {
    private static class TestMicroType extends MicroType<String> {
        protected TestMicroType(String s) {
            super(s);
        }
    }

    @Test(expected = RuntimeException.class)
    public void isAbstract() {
        MicroTypes.instance(MicroType.class, "Test");
    }

    @Test
    public void nullValueDoesNotThrowException() {
        MicroTypes.instance(TestMicroType.class, null);
    }
}