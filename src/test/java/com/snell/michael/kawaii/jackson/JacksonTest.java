package com.snell.michael.kawaii.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.io.CharStreams;
import com.snell.michael.kawaii.person.Person;
import com.snell.michael.kawaii.person.Persons;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;

public class JacksonTest {
    private final ObjectMapper objectMapper = new ObjectMapper()
        .registerModule(new KawaiiModule())
        .enable(SerializationFeature.INDENT_OUTPUT);

    @Test
    public void writeValue() throws IOException {
        String expectedJson = CharStreams.toString(new InputStreamReader(getClass().getResourceAsStream("person.json")));

        Person person = Persons.newPerson("Michael Alphonso Snell", 21, "michael@redacted.com");
        String json = objectMapper.writeValueAsString(person);
        assertEquals(expectedJson, json);
    }

    @Test
    public void readValue() throws IOException {
        Person expectedPerson = Persons.newPerson("Michael Alphonso Snell", 21, "michael@redacted.com");

        String json = CharStreams.toString(new InputStreamReader(getClass().getResourceAsStream("person.json")));
        Person readPerson = objectMapper.readValue(json, Person.class);
        assertEquals(expectedPerson, readPerson);
    }
}
