package com.snell.michael.kawaii.person;

import org.junit.Test;

import static com.google.common.collect.Iterables.getOnlyElement;
import static org.junit.Assert.assertEquals;

public class PersonTest {
    @Test
    public void canCreateValidPerson() {
        Person person = Persons.newPerson("Michael Alphonso Snell", 21, "michael@redacted.com");
        assertEquals(new MiddleName("Alphonso"), getOnlyElement(person.getMiddleNames()));
    }

    @Test(expected = RuntimeException.class)
    public void failOnInvalidAge() {
        Persons.newPerson("Michael Alphonso Snell", -1, "michael@redacted.com");
    }
}
