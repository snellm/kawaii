package com.snell.michael.kawaii;

import com.snell.michael.kawaii.person.FirstName;
import com.snell.michael.kawaii.person.LastName;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class MicroTypeStringsTest {
    private static final List<String> STRINGS = Arrays.asList("Hello", "World");

    @Test
    public void toUpperCase() {
        List<FirstName> list = STRINGS.stream()
                .map(FirstName::new)
                .collect(toList());

        List<FirstName> result = list.stream()
            .map(MicroTypeStrings::toUpperCase)
            .collect(toList());

        assertEquals(new FirstName("HELLO"), result.get(0));
    }

    @Test
    public void toLowerCase() {
        List<LastName> list = STRINGS.stream()
            .map(LastName::new)
            .collect(toList());

        List<LastName> result = list.stream()
            .map(MicroTypeStrings::toLowerCase)
            .collect(toList());

        assertEquals(new LastName("hello"), result.get(0));
    }
}