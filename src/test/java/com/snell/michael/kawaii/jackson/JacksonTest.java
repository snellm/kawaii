package com.snell.michael.kawaii.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.snell.michael.kawaii.person.Person;
import com.snell.michael.kawaii.person.PersonJSON;
import com.snell.michael.kawaii.person.Persons;
import com.snell.michael.kawaii.resource.ResourceLoader;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class JacksonTest {
    public static final Path PERSON_JSON_PATH = Paths.get("person.json");

    private final ResourceLoader resourceLoader = new ResourceLoader(getClass());

    private final ObjectMapper objectMapper = new ObjectMapper()
        .enable(SerializationFeature.INDENT_OUTPUT);

    private final KawaiiObjectMapper kawaiiObjectMapper = new KawaiiObjectMapper(objectMapper);

    @Test
    public void writeValue() throws IOException {
        PersonJSON expectedJSON = resourceLoader.readResource(PersonJSON.class, PERSON_JSON_PATH);

        Person person = Persons.newPerson("Michael Alphonso Snell", 21, "michael@redacted.com");
        PersonJSON actualJSON = kawaiiObjectMapper.writeValueAs(PersonJSON.class, person);
        assertEquals(expectedJSON, actualJSON);
    }

    @Test
    public void readValue() throws IOException {
        Person expectedPerson = Persons.newPerson("Michael Alphonso Snell", 21, "michael@redacted.com");

        PersonJSON personJSON = resourceLoader.readResource(PersonJSON.class, PERSON_JSON_PATH);
        Person readPerson = kawaiiObjectMapper.readValue(personJSON, Person.class);
        assertEquals(expectedPerson, readPerson);
    }
}
