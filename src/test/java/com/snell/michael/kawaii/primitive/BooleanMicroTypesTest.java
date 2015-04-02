package com.snell.michael.kawaii.primitive;

import com.snell.michael.kawaii.person.Admin;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BooleanMicroTypesTest {
    @Test
    public void is() {
        assertTrue(BooleanMicroTypes.is(Admin.TRUE));
        assertFalse(BooleanMicroTypes.is(Admin.FALSE));
    }
}