package org.model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;


/**
 * Represents an Employee, which is a type of {@link Person}.
 */
public final class Employee extends Person {
    private final String role;
    private BigDecimal salary;

    /**
     * Constructs an {@code Employee} with the specified name, birthdate, salary, and role.
     *
     * @param name      the name of the employee
     * @param birthDate the birthdate of the employee
     * @param salary    the salary of the employee
     * @param role      the role of the employee
     * @throws IllegalArgumentException if the salary or role is null
     */
    public Employee(String name, LocalDate birthDate, BigDecimal salary, String role) {
        super(name, birthDate);
        if (salary == null || role == null) {
            throw new IllegalArgumentException("Salary and role cannot be null");
        }

        this.salary = salary;
        this.role = role;
    }

    /**
     * Returns a {@link BigDecimal} that represents the salary of the employee.
     *
     * @return the salary of the employee
     */
    public BigDecimal getSalary() {
        return salary;
    }

    /**
     * Sets the salary of the employee.
     *
     * @param salary the new salary to set
     */
    private void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    /**
     * Returns the role of the employee.
     *
     * @return the role of the employee
     */
    public String getRole() {
        return role;
    }

    /**
     * Increases the salary of the employee by a given percentage.
     *
     * @param percentage the percentage to increase the salary by
     */
    public void increaseSalary(Integer percentage) {
        setSalary(
                getSalary()
                        .add(getSalary()
                                .multiply(BigDecimal.valueOf(percentage / 100.0))));
    }

    @Override
    public String toString() {
        return String.format(
                "Nome: %s, Data de Nascimento: %s, Salário: R$%s, Função: %s",
                getName(),
                getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                NumberFormat.getInstance(Locale.of("pt", "BR")).format(getSalary()),
                getRole()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getSalary(), employee.getSalary()) && Objects.equals(getRole(), employee.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBirthDate(), getSalary(), getRole());
    }
}