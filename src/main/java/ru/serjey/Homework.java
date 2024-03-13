package ru.serjey;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Homework {

    /**
     * Реалзиовать методы, описанные ниже:
     */

    /**
     * Вывести на консоль отсортированные (по алфавиту) имена персонов
     */
    public void printNamesOrdered(List<Person> persons) {


        // ...
    }

    /**
     * В каждом департаменте найти самого взрослого сотрудника.
     * Вывести на консоль мапипнг department -> personName
     * Map<Department, Person>
     */
    public Map<Department, Person> printDepartmentOldestPerson(List<Person> persons) {
        throw new UnsupportedOperationException();
    }

    /**
     * Найти 10 первых сотрудников, младше 30 лет, у которых зарплата выше 50_000
     */
    public List<Person> findFirstPersons(List<Person> persons) {
        throw new UnsupportedOperationException();
    }

    /**
     * Найти депаратмент, чья суммарная зарплата всех сотрудников максимальна
     */
    public Optional<Department> findTopDepartment(List<Person> persons) {
        throw new UnsupportedOperationException();
    }




}
