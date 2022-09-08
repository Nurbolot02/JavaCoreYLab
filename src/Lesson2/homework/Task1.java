package Lesson2.homework;

import java.util.*;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        List<Person> RAW_DATA = new ArrayList<>();
        Collections.addAll(RAW_DATA,
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
                new Person(8, "Amelia"));
        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            System.out.println(person.getId() + " - " + person.getName());
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();

        long startTime = System.nanoTime();
        filterDuplicate(RAW_DATA);
        long endTime = System.nanoTime();
        System.out.printf("my method: %s ms\n", endTime - startTime);

        startTime = System.nanoTime();
        RAW_DATA = RAW_DATA.stream()
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
        endTime = System.nanoTime();
        System.out.printf("stream method: %s ms\n", endTime - startTime);


        startTime = System.nanoTime();
        TreeMap<String, PriorityQueue<Person>> res = groupNameAndSortId(RAW_DATA);
        endTime = System.nanoTime();
        System.out.printf("groupNameAndSortId method: %s ms\n", endTime - startTime);

        print(res);
    }

    public static TreeMap<String, PriorityQueue<Person>> groupNameAndSortId(List<Person> RAW_DATA) {
        if (RAW_DATA == null) throw new NullPointerException("Raw_Data is null");
        TreeMap<String, PriorityQueue<Person>> res = new TreeMap<>();
        for (Person raw_datum : RAW_DATA) {
            if (!res.containsKey(raw_datum.getName())) {
                res.put(raw_datum.getName(), new PriorityQueue<>(Collections.singletonList(raw_datum)));
            } else {
                res.get(raw_datum.getName()).add(raw_datum);
            }
        }
        return res;
    }

    public static void filterDuplicate(List<Person> RAW_DATA) {
        if (RAW_DATA == null) throw new NullPointerException("Raw_Data is null");
        for (int i = 0; i < RAW_DATA.size(); i++) {
            for (int j = 0; j < RAW_DATA.size(); j++) {
                if ((i != j) && RAW_DATA.get(i).getId() == RAW_DATA.get(j).getId()) {
                    RAW_DATA.remove(j);
                }
            }
        }
    }

    public static void print(TreeMap<String, PriorityQueue<Person>> treeMap) {
        if (treeMap == null) throw new NullPointerException("treeMap is null");
        for (String key : treeMap.keySet()) {
            int i = 1;
            for (Person person : treeMap.get(key)) {
                if (i == 1) {
                    System.out.println(person.getName() + ":");
                }
                System.out.printf("%x - %s (%x) \n", i++, person.getName(), person.getId());
            }
        }
    }
}

