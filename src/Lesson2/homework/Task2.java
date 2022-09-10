package Lesson2.homework;

import java.util.*;

public class Task2 {
    /*
    [3, 4, 2, 7], 10 -> [3, 7] - вывести пару менно в скобках, которые дают сумму - 10
     */
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 4, 2, 7);
        int waitingResult = 10;
        List<Integer> result = new ArrayList<>();
        try {
            result = findPairNumbers(numbers, waitingResult);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println((result.size() == 2 ?
                "первые пару чисел, которые дают в сумме " + waitingResult + ": " + result
                : "Не удалось найти пару сумма которых будет равен " + waitingResult));
    }

    public static List<Integer> findPairNumbers(List<Integer> array, int waitingResult) {
        if (array == null) throw new IllegalArgumentException("Array is null!");
        if (array.size() < 2) throw new IllegalArgumentException("There are not enough elements in the array!");

        Map<Integer, Integer> neededNumberAndHaveNumber = new HashMap<>();

        for (int number : array) {
            int neededNumber = waitingResult - number;
            if (neededNumberAndHaveNumber.containsKey(number)) {
                return Arrays.asList(neededNumber, number);
            }
            neededNumberAndHaveNumber.put(neededNumber, number);
        }
        return new ArrayList<Integer>();
    }
}
