package Lesson2.homework;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<Person> RAW_DATA = new ArrayList<>();
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


        filterDuplicate(RAW_DATA);
        TreeMap<String, PriorityQueue<Person>> res = groupNameAndSortId(RAW_DATA);
        print(res);
    }

    public static TreeMap<String, PriorityQueue<Person>> groupNameAndSortId(ArrayList<Person> RAW_DATA) {
        TreeMap<String, PriorityQueue<Person>> res = new TreeMap<>();
        for (int i = 0; i < RAW_DATA.size(); i++) {
            if (!res.containsKey(RAW_DATA.get(i).getName())) {
                res.put(RAW_DATA.get(i).getName(), new PriorityQueue<>(Collections.singletonList(RAW_DATA.get(i))));
            } else {
                res.get(RAW_DATA.get(i).getName()).add(RAW_DATA.get(i));
            }
        }
        return res;
    }

    public static void filterDuplicate(ArrayList<Person> RAW_DATA) {
        for (int i = 0; i < RAW_DATA.size(); i++) {
            for (int j = 0; j < RAW_DATA.size(); j++) {
                if ((i != j) && RAW_DATA.get(i).getId() == RAW_DATA.get(j).getId()) {
                    RAW_DATA.remove(j);
                }
            }
        }
    }

    public static void print(TreeMap<String, PriorityQueue<Person>> treeMap) {
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

