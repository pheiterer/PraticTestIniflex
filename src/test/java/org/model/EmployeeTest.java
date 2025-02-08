package org.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee("John Doe", LocalDate.of(1990, 1, 1), BigDecimal.valueOf(1000), "Developer");
    }

    @Test
    void getSalaryReturnsCorrectValue() {
        assertEquals(BigDecimal.valueOf(1000), employee.getSalary());
    }

    @Test
    void getRoleReturnsCorrectValue() {
        assertEquals("Developer", employee.getRole());
    }

    @Test
    void increaseSalaryIncreasesSalaryByGivenPercentage() {
        employee.increaseSalary(10);
        assertEquals(BigDecimal.valueOf(1100.0), employee.getSalary());
    }

    @Test
    void toStringReturnsFormattedString() {
        String expected = "Nome: John Doe, Data de Nascimento: 01/01/1990, Salário: R$1.000, Função: Developer";
        assertEquals(expected, employee.toString());
    }

    @Test
    void equalsReturnsTrueForSameInstance() {
        assertEquals(employee, employee);
    }

    @Test
    void equalsReturnsTrueForEqualObjects() {
        Employee sameEmployee = new Employee("John Doe", LocalDate.of(1990, 1, 1), BigDecimal.valueOf(1000), "Developer");
        assertEquals(employee, sameEmployee);
    }

    @Test
    void equalsReturnsFalseForDifferentObjects() {
        Employee differentEmployee = new Employee("Jane Doe", LocalDate.of(1992, 2, 2), BigDecimal.valueOf(2000), "Manager");
        assertNotEquals(employee, differentEmployee);
    }

    @Test
    void hashCodeReturnsSameValueForEqualObjects() {
        Employee sameEmployee = new Employee("John Doe", LocalDate.of(1990, 1, 1), BigDecimal.valueOf(1000), "Developer");
        assertEquals(employee.hashCode(), sameEmployee.hashCode());
    }

    @Test
    void constructorThrowsExceptionForNullSalary() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Employee("John Doe", LocalDate.of(1990, 1, 1), null, "Developer");
        });
        assertEquals("Salary and role cannot be null", exception.getMessage());
    }

    @Test
    void constructorThrowsExceptionForNullRole() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Employee("John Doe", LocalDate.of(1990, 1, 1), BigDecimal.valueOf(1000), null);
        });
        assertEquals("Salary and role cannot be null", exception.getMessage());
    }
}