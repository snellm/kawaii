package com.snell.michael.kawaii.person;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

import java.util.List;
import java.util.stream.Collectors;

public class Persons {
    private Persons() {}

    public static Person newPerson(String name, int age, String emailAddress) {
        List<String> splitNames = Splitter.on(CharMatcher.WHITESPACE).omitEmptyStrings().splitToList(name);

        FirstName firstName = new FirstName(splitNames.get(0));
        List<MiddleName> middleNames = splitNames
            .subList(1, splitNames.size() - 1)
            .stream()
            .map(MiddleName::new)
            .collect(Collectors.toList());
        LastName lastName = new LastName(splitNames.get(splitNames.size() - 1));

        return new Person(firstName, middleNames, lastName, new Age(age), new EmailAddress(emailAddress));
    }
}
