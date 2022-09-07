package Lesson2.homework;

import java.util.Arrays;

public class Task2 {
    /*
    [3, 4, 2, 7], 10 -> [3, 7] - вывести пару менно в скобках, которые дают сумму - 10
     */
    public static void main(String[] args) {
        int[] numbers = {3, 4, 2, 7};
        int waitingResult = 10;
        int[] result = findPairNumbers(numbers, waitingResult);
        System.out.println((result.length == 2 ?
                "первые пару чисел, которые дают в сумме " + waitingResult + ": " + Arrays.toString(result)
                : "Не удалось найти пару сумма которых будет равен " + waitingResult));

    }

    public static int[] findPairNumbers(int[] array, int waitingResult) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] + array[j] == waitingResult) {
                    return new int[]{array[i], array[j]};
                }
            }
        }
        return new int[]{};
    }
}
