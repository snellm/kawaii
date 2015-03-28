package com.snell.michael.kawaii.person;

import java.util.List;

public class Person {
    private final FirstName firstname;
    private final List<MiddleName> middleNames;
    private final LastName lastName;

    private final Age age;
    private final EmailAddress emailAddress;

    public Person(FirstName firstname, List<MiddleName> middleNames, LastName lastName, Age age, EmailAddress emailAddress) {
        this.firstname = firstname;
        this.middleNames = middleNames;
        this.lastName = lastName;
        this.age = age;
        this.emailAddress = emailAddress;

    }

    public FirstName getFirstname() {
        return firstname;
    }

    public List<MiddleName> getMiddleNames() {
        return middleNames;
    }

    public LastName getLastName() {
        return lastName;
    }

    public Age getAge() {
        return age;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }
}
