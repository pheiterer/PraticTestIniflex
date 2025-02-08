package org.main;

import org.data.DbContext;
import org.model.Employee;
import org.model.Person;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        DbContext dbContext = new DbContext();

        //Removing João
        dbContext.removePersonByName("João");

        System.out.println("\nImprimi todos os funcionários");
        for (Person person : dbContext.getPersonList()) {
            System.out.println(person.toString());
        }

        //Increasing the salary of all employees
        for (Person person : dbContext.getPersonList()) {
            ((Employee) person).increaseSalary(10);
        }

        //Declare variables to use in the further
        List<Person> personList = dbContext.getPersonList();
        List<Employee> employeeStream = personList.stream()
                .map(Employee.class::cast).toList();

        Map<String, List<Employee>> employees = employeeStream.stream()
                .collect(Collectors.groupingBy(Employee::getRole));

        System.out.println("\nImprimi os funcionários, agrupados por função");
        employees.forEach((role, empList) -> {
            System.out.println("\nRole: " + role);
            empList.forEach(employee -> System.out.println("  " + employee));
        });

        System.out.println("\nImprime funcionários que fazem aniversário no mês 10 e 12");
        personList.stream()
                .filter(person -> {
                    int month = person.getBirthDate().getMonthValue();
                    return month == 10 || month == 12;
                })
                .forEach(System.out::println);

        System.out.println("\nFuncionário mais velho:");
        personList.stream()
                .min(Comparator.comparing(Person::getBirthDate))
                .ifPresent(person -> System.out.println("Name: " + person.getName() + ", Age: " + person.getAge()));

        System.out.println("\nImprime lista em ordem alfabética");
        personList.stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);

        System.out.println("\nSalário Total: " + employeeStream.stream()
                .map(Employee::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add));

        employeeStream
                .forEach(employee -> {
                    short howMany = (short) (employee.getSalary().intValue() / 1212);
                    System.out.printf("%nNome: %s ganha %s salário mínimos",
                            employee.getName(),
                            howMany);
                });
    }
}