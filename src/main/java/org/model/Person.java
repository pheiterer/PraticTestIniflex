package org.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Abstract sealed class representing a person.
 */
public abstract sealed class Person permits Employee {
    private final String name;
    private final LocalDate birthDate;

    /**
     * Constructs a new Person with the specified name and birthdate.
     *
     * @param name      the name of the person
     * @param birthdate the birthdate of the person
     * @throws IllegalArgumentException if the name or birthdate is null
     */
    public Person(String name, LocalDate birthdate) {
        if (name == null || birthdate == null) {
            throw new IllegalArgumentException("Name and birthdate cannot be null");
        }
        this.name = name;
        this.birthDate = birthdate;
    }

    /**
     * Returns the name of the person.
     *
     * @return the name of the person
     */
    public final String getName() {
        return name;
    }

    /**
     * Returns the birthdate of the person.
     *
     * @return the birthdate of the person
     */
    public final LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Returns the age of the person.
     *
     * @return the age of the person
     */
    public final short getAge() {
        return (short) (LocalDate.now().getYear() - birthDate.getYear());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(getName(), person.getName()) && Objects.equals(getBirthDate(), person.getBirthDate());
    }
}