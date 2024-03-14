package ru.serjey;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Homework {

    /*
      Реалзиовать методы, описанные ниже:
     */

    /**
     * Вывести на консоль отсортированные (по алфавиту) имена персонов
     */
    public void printNamesOrdered(List<Person> persons) {
        persons.stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }

    /**
     * В каждом департаменте найти самого взрослого сотрудника.
     * Вывести на консоль мапипнг department -> personName
     * Map<Department, Person>
     */
    public Map<Department, Person> printDepartmentOldestPerson(List<Person> persons) {
        if (persons.isEmpty()) {
            throw new UnsupportedOperationException();
        }

        return persons.stream()
                .collect(Collectors.toMap(Person::getDepartment, Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparing(Person::getAge))));
    }



    /**
     * Найти 10 первых сотрудников, младше 30 лет, у которых зарплата выше 50_000
     */
    public List<Person> findFirstPersons(List<Person> persons) {
        if (persons.isEmpty()) {
            throw new UnsupportedOperationException();
        }

        return persons.stream()
                .filter(it -> it.getAge() < 30)
                .filter(it -> it.getSalary() > 50_000)
                .limit(10)
                .toList();
    }

    /**
     * Найти департамент, чья суммарная зарплата всех сотрудников максимальна
     */
    public Optional<Department> findTopDepartment(List<Person> persons) {
        if (persons.isEmpty()) {
            throw new UnsupportedOperationException();

        }

        Map<Department, Double> departmentSalarySum = persons.stream()
                .collect(Collectors.groupingBy(Person::getDepartment, Collectors.summingDouble(Person::getSalary)));

        return departmentSalarySum.entrySet().stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey);
    }


}
