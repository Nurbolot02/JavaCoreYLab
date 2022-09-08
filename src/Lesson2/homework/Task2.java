package Lesson2.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2 {
    /*
    [3, 4, 2, 7], 10 -> [3, 7] - вывести пару менно в скобках, которые дают сумму - 10
     */
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 4, 2, 7);
        int waitingResult = 10;
        List<Integer> result = findPairNumbers(numbers, waitingResult);
        System.out.println((result.size() == 2 ?
                "первые пару чисел, которые дают в сумме " + waitingResult + ": " + result
                : "Не удалось найти пару сумма которых будет равен " + waitingResult));
    }

    public static List<Integer> findPairNumbers(List<Integer> array, int waitingResult) {
        if (array == null) throw new NullPointerException("array is null");
        for (int i : array) {
            if (array.contains((waitingResult - i))) {
                return Arrays.asList(i, (waitingResult - i));
            }
        }
        return new ArrayList<>();
    }
}
