package org.data;

import org.json.JSONArray;
import org.json.JSONObject;
import org.model.Employee;
import org.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a database context that manages {@link Person} objects.
 * This class reads data from a JSON file and populates a list of Person objects.
 * Start with a capacity of 10 elements
 */
public final class DbContext {
    private final List<Person> personMap;

    /**
     * Constructs a DbContext object and initializes the personMap list.
     * Reads data from a JSON file and populates the personMap list with Employee objects.
     */
    public DbContext() {
        personMap = new ArrayList<>();
        try {
            final String jsonFile = Files.readString(Paths.get("src/main/resources/Employees.json"));
            final JSONArray jsonArray = new JSONArray(jsonFile);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Employee employee = new Employee(
                        jsonObject.getString("nome"),
                        LocalDate.parse(jsonObject.getString("dataNascimento")),
                        jsonObject.getBigDecimal("salario"),
                        jsonObject.getString("funcao")
                );
                this.addPerson(employee);
            }
        } catch (DateTimeParseException | IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Adds a {@link Person} object to the personMap list.
     *
     * @param person the {@link Person} object to be added
     */
    public void addPerson(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }
        personMap.add(person);
    }

    /**
     * Removes a {@link Person} object from the personMap list by name.
     *
     * @param name the name of the {@link Person} to be removed
     */
    public void removePersonByName(String name) {
        personMap.removeIf(p -> p.getName().equals(name));
    }

    /**
     * Returns the list of {@link Person} objects in the personMap.
     *
     * @return the list of {@link Person} objects
     */
    public List<Person> getPersonList() {
        return personMap;
    }
}