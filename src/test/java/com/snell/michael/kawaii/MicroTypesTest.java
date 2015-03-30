package com.snell.michael.kawaii;

import com.snell.michael.kawaii.person.FirstName;
import org.junit.Test;

import java.util.Optional;

import static com.snell.michael.kawaii.MicroTypes.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MicroTypesTest {
    @Test
    public void nonNullValueCanBeInstantiated() {
        assertNotNull(newMicroType(FirstName.class, "Test"));
    }

    @Test(expected = RuntimeException.class)
    public void instanceThrowsExceptionIfValueIsNull() {
        assertEquals(null, newMicroType(FirstName.class, null));
    }

    @Test
    public void nullableInstanceReturnsNullIfValueIsNull() {
        assertEquals(null, newNullableMicroType(FirstName.class, null));
    }

    @Test
    public void optionalInstanceisEmptyIfValueNull() {
        assertEquals(Optional.empty(), newOptionalMicroType(FirstName.class, null));
    }
}