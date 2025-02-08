package org.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.model.Employee;
import org.model.Person;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DbContextTest {

    private DbContext dbContext;

    @BeforeEach
    void setUp() {
        dbContext = new DbContext();
    }

    @Test
    void addPersonAddsPersonToList() {
        Person person = new Employee("Alice Smith", LocalDate.of(1985, 5, 15), BigDecimal.valueOf(1500), "Analyst");
        dbContext.addPerson(person);
        assertTrue(dbContext.getPersonList().contains(person));
    }

    @Test
    void addPersonThrowsExceptionForNullPerson() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            dbContext.addPerson(null);
        });
        assertEquals("Person cannot be null", exception.getMessage());
    }

    @Test
    void removePersonByNameRemovesCorrectPerson() {
        Person person = new Employee("Bob Johnson", LocalDate.of(1978, 3, 22), BigDecimal.valueOf(2000), "Manager");
        dbContext.addPerson(person);
        dbContext.removePersonByName("Bob Johnson");
        assertFalse(dbContext.getPersonList().contains(person));
    }

    @Test
    void removePersonByNameDoesNothingForNonExistentPerson() {
        int initialSize = dbContext.getPersonList().size();
        dbContext.removePersonByName("Non Existent");
        assertEquals(initialSize, dbContext.getPersonList().size());
    }

    @Test
    void getPersonListReturnsAllPersons() {
        List<Person> personList = dbContext.getPersonList();
        assertNotNull(personList);
        assertFalse(personList.isEmpty());
    }
}