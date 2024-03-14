package ru.serjey;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        List<Department> departments = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            departments.add(new Department("Department #" + i));
        }

        List<Person> employee = new ArrayList<>();
        String[] names = {
                "Александр", "Дмитрий", "Михаил", "Сергей", "Андрей",
                "Алексей", "Иван", "Юрий", "Владимир", "Николай",
                "Евгений", "Павел", "Константин", "Виктор", "Игорь",
                "Василий", "Олег", "Артем", "Антон", "Максим",
                "Георгий", "Роман", "Станислав", "Григорий", "Валентин"
        };
        for (int i = 0; i < 100; i++) {
            employee.add(new Person(
                    names[ThreadLocalRandom.current().nextInt(names.length)],
                    ThreadLocalRandom.current().nextInt(20, 61),
                    ThreadLocalRandom.current().nextInt(20_000, 100_000) * 1.0,
                    departments.get(ThreadLocalRandom.current().nextInt(departments.size()))
            ));
        }


        Homework homework = new Homework();

        homework.printNamesOrdered(employee);

        System.out.println("==========================================");

        homework.findFirstPersons(employee);

        System.out.println("==========================================");

        Map<Department, Person> oldestEmployeeInEachDepartment = homework.printDepartmentOldestPerson(employee);

        oldestEmployeeInEachDepartment.forEach((department, person) ->
                System.out.println(department + " -> " + person.getName()));

        System.out.println("==========================================");

        List<Person> people = homework.findFirstPersons(employee);

        people.forEach(System.out::println);

        System.out.println("==========================================");

        System.out.println(homework.findTopDepartment(employee));
    }
}