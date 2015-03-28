package com.snell.michael.kawaii.person;

import java.util.List;

public class Person {
    private final FirstName firstName;
    private final List<MiddleName> middleNames;
    private final LastName lastName;

    private final Age age;
    private final EmailAddress emailAddress;

    // Required for Jackson
    private Person() {
        firstName = null;
        middleNames = null;
        lastName = null;
        age = null;
        emailAddress = null;
    };

    public Person(FirstName firstName, List<MiddleName> middleNames, LastName lastName, Age age, EmailAddress emailAddress) {
        this.firstName = firstName;
        this.middleNames = middleNames;
        this.lastName = lastName;
        this.age = age;
        this.emailAddress = emailAddress;
    }

    public FirstName getFirstName() {
        return firstName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!firstName.equals(person.firstName)) return false;
        if (!middleNames.equals(person.middleNames)) return false;
        if (!lastName.equals(person.lastName)) return false;
        if (!age.equals(person.age)) return false;
        return emailAddress.equals(person.emailAddress);

    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + middleNames.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + age.hashCode();
        result = 31 * result + emailAddress.hashCode();
        return result;
    }
}
