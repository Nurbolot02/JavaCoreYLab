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
            System.out.println(person.id + " - " + person.name);
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();


        TreeMap<String, PriorityQueue> res = new TreeMap<>();

        for (int i = 0; i < RAW_DATA.size(); i++) {
            if (!res.containsKey(RAW_DATA.get(i).name)) {
                res.put(RAW_DATA.get(i).name.toString(), new PriorityQueue<>());
                PriorityQueue personPriorityQueue = res.get(RAW_DATA.get(i).name);
                personPriorityQueue.add(RAW_DATA.get(i));
            } else if (res.containsKey(RAW_DATA.get(i).name)) {
                PriorityQueue personPriorityQueue = res.get(RAW_DATA.get(i).name);
                personPriorityQueue.add(RAW_DATA.get(i));
            }
            for (int j = 0; j < RAW_DATA.size(); j++) {
                if ((i != j) && (RAW_DATA.get(i).id == RAW_DATA.get(j).id && RAW_DATA.get(i).name.equalsIgnoreCase(RAW_DATA.get(j).name))) {
                    RAW_DATA.remove(j);
                }
            }
        }
        print(res);
    }

    public static void print(TreeMap treeMap) {
        for (Object key : treeMap.keySet()) {
            PriorityQueue priorityQueue = (PriorityQueue) treeMap.get(key);
            for (int i = 1; !priorityQueue.isEmpty(); i++) {
                Person person = (Person) priorityQueue.poll();
                if (i == 1) {
                    System.out.println(person.name + ":");
                }
                System.out.printf("%x - %s (%x) \n", i, person.name, person.id);
            }
        }
    }
}

