package com.snell.michael.kawaii;

import com.snell.michael.kawaii.person.FirstName;
import org.junit.Test;

public class PrimitiveMicroTypeTest {
    @Test(expected = RuntimeException.class)
    public void valueCannotBeNull() {
        new FirstName(null);
    }
}