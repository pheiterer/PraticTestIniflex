package org.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person person;

    @BeforeEach
    void setUp() {
        person = new Employee("John Doe", LocalDate.of(1990, 1, 1), BigDecimal.valueOf(1000), "Developer");
    }

    @Test
    void getNameReturnsCorrectValue() {
        assertEquals("John Doe", person.getName());
    }

    @Test
    void getBirthDateReturnsCorrectValue() {
        assertEquals(LocalDate.of(1990, 1, 1), person.getBirthDate());
    }

    @Test
    void getAgeReturnsCorrectValue() {
        final int currentYear = LocalDate.now().getYear();
        final int expectedAge = currentYear - 1990;
        assertEquals(expectedAge, person.getAge());
    }

    @Test
    void equalsReturnsTrueForSameInstance() {
        assertEquals(person, person);
    }

    @Test
    void equalsReturnsTrueForEqualObjects() {
        Person samePerson = new Employee("John Doe", LocalDate.of(1990, 1, 1), BigDecimal.valueOf(1000), "Developer");
        assertEquals(person, samePerson);
    }

    @Test
    void equalsReturnsFalseForDifferentObjects() {
        Person differentPerson = new Employee("Jane Doe", LocalDate.of(1992, 2, 2), BigDecimal.valueOf(2000), "Manager");
        assertNotEquals(person, differentPerson);
    }

    @Test
    void hashCodeReturnsSameValueForEqualObjects() {
        Person samePerson = new Employee("John Doe", LocalDate.of(1990, 1, 1), BigDecimal.valueOf(1000), "Developer");
        assertEquals(person.hashCode(), samePerson.hashCode());
    }

    @Test
    void constructorThrowsExceptionForNullName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Employee(null, LocalDate.of(1990, 1, 1), BigDecimal.valueOf(1000), "Developer");
        });
        assertEquals("Name and birthdate cannot be null", exception.getMessage());
    }

    @Test
    void constructorThrowsExceptionForNullBirthDate() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Employee("John Doe", null, BigDecimal.valueOf(1000), "Developer");
        });
        assertEquals("Name and birthdate cannot be null", exception.getMessage());
    }

    @Test
    void constructorThrowsExceptionForNullNameAndBirthDate() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Employee(null, null, BigDecimal.valueOf(1000), "Developer");
        });
        assertEquals("Name and birthdate cannot be null", exception.getMessage());
    }
}