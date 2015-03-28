package com.snell.michael.kawaii.person;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.io.CharStreams;
import com.snell.michael.kawaii.jackson.KawaiiObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;

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

    @Test
    public void parse() throws IOException {
        Person expectedPerson = Persons.newPerson("Michael Alphonso Snell", 21, "michael@redacted.com");
        String expectedJson = CharStreams.toString(new InputStreamReader(getClass().getResourceAsStream("person.json")));

        ObjectMapper objectMapper = new KawaiiObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        String json = objectMapper.writeValueAsString(expectedPerson);
        assertEquals(expectedJson, json);

        Person readPerson = objectMapper.readValue(json, Person.class);
        assertEquals(expectedPerson, readPerson);
    }
}
