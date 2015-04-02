package com.snell.michael.kawaii.adapter.jackson;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.snell.michael.kawaii.person.Person;
import com.snell.michael.kawaii.person.PersonJSONString;
import com.snell.michael.kawaii.resource.ClasspathResources;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.snell.michael.kawaii.person.Persons.createPerson;
import static org.junit.Assert.assertEquals;

public class JacksonJSONTest {
    private static final Path PERSON_JSON_PATH = Paths.get("person.json");
    private static final Person PERSON = createPerson("Michael", "Alphonso", "Snell", 21, "michael@redacted.com", "foobar");

    private final ClasspathResources classpathResources = new ClasspathResources(getClass());

    private final KawaiiObjectMapper kawaiiObjectMapper = new KawaiiObjectMapper()
        .enable(SerializationFeature.INDENT_OUTPUT);

    @Test
    public void writeValueAs() throws IOException {
        PersonJSONString expectedJSON = classpathResources.read(PersonJSONString.class, PERSON_JSON_PATH);
        PersonJSONString actualJSON = kawaiiObjectMapper.writeValueAs(PersonJSONString.class, PERSON);
        assertEquals(expectedJSON, actualJSON);
    }

    @Test
    public void readValue() throws IOException {
        PersonJSONString personJSON = classpathResources.read(PersonJSONString.class, PERSON_JSON_PATH);
        Person actualPerson = kawaiiObjectMapper.readValue(personJSON, Person.class);
        assertEquals(PERSON, actualPerson);
    }
}
