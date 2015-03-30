package com.snell.michael.kawaii.person;

import static java.util.Collections.singletonList;

// Odd formatting for blog
public class Persons {
    private Persons() {}

    public static
    Person createPerson(String firstName, String middleName, String lastName, int age, String emailAddress, String password)
    {
        return new Person(new FirstName(firstName), singletonList(new MiddleName(middleName)), new LastName(lastName),
            new Age(age), new EmailAddress(emailAddress), new Password(password));
    }

    public static
    Person createPerson(FirstName firstName, MiddleName middleName, LastName lastName, Age age, EmailAddress emailAddress, Password password)
    {
        return new Person(firstName, singletonList(middleName), lastName, age, emailAddress, password);
    }
}
