package Lesson2.homework;

import java.util.*;
import java.util.stream.Collectors;

public class Task1 {
    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
            null,
            new Person(9, null)
    };

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        groupNameAndSortId(RAW_DATA);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }

    public static void groupNameAndSortId(Person[] RAW_DATA) {
        if (RAW_DATA == null) throw new NullPointerException("Raw_Data is null");
        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            if (person == null) continue;
            System.out.println(person.getId() + " - " + person.getName());
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();

        Arrays.stream(RAW_DATA)
                .filter(Objects::nonNull)
                .filter(obj -> obj.getName() != null)
                .distinct()
                .sorted(Comparator.comparing(Person::getId))
                .collect(Collectors.groupingBy(Person::getName, Collectors.counting()))
                .forEach((k, v) -> System.out.printf("Key: %s\nValue:%d\n", k, v));
    }
}

