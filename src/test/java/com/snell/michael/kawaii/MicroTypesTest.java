package com.snell.michael.kawaii;

import com.snell.michael.kawaii.person.FirstName;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MicroTypesTest {
    @Test
    public void nonNullValueCanBeInstantiated() {
        assertNotNull(MicroTypes.instance(FirstName.class, "Test"));
    }

    @Test(expected = RuntimeException.class)
    public void instanceThrowsExceptionIfValueIsNull() {
        assertEquals(null, MicroTypes.instance(FirstName.class, null));
    }

    @Test
    public void nullableInstanceReturnsNullIfValueIsNull() {
        assertEquals(null, MicroTypes.nullableInstance(FirstName.class, null));
    }

    @Test
    public void optionalInstanceisEmptyIfValueNull() {
        assertEquals(Optional.empty(), MicroTypes.optionalInstance(FirstName.class, null));
    }
}