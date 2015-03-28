package com.snell.michael.kawaii;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class MicroTypesTest {

    @Test(expected = RuntimeException.class)
    public void instanceThrowsExceptionIfValueIsNull() {
        assertEquals(null, MicroTypes.instance(TestMicroType.class, null));
    }

    @Test
    public void nullableInstanceReturnsNullIfValueIsNull() {
        assertEquals(null, MicroTypes.nullableInstance(TestMicroType.class, null));
    }

    @Test
    public void optionalInstanceisEmptyIfValueNull() {
        assertEquals(Optional.empty(), MicroTypes.optionalInstance(TestMicroType.class, null));
    }
}