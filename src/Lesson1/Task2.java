package Lesson1;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Select sort program
 *
 * @author Nurbolot Gulamidinov
 * @version 1.0.0
 */

public class Task2 {
    public static void main(String[] args) {
        /*
        [5,6,3,2,5,1,4,9]
         */
        int[] array = {5, 6, 3, 2, 5, 1, 4, 9, 7, 3, 5};
        System.out.println(Arrays.toString(array));
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * Select sort - Optimized version
     *
     * @param array int[] array
     */
    public static void selectSort(int[] array) {
        int arrayLength = array.length % 2 == 0 ? array.length / 2 : array.length / 2 + 1;
        int minNumberIndex = 0, maxNumberIndex = 0, buffer;
        for (int i = 0; i < arrayLength; i++) {
            minNumberIndex = i;
            maxNumberIndex = i;
            for (int j = i + 1; j < array.length - i; j++) {
                if (array[j] > array[maxNumberIndex]) {
                    maxNumberIndex = j;
                } else if (array[j] < array[minNumberIndex]) {
                    minNumberIndex = j;
                }
            }
            buffer = array[i];
            array[i] = array[minNumberIndex];
            array[minNumberIndex] = buffer;
            if (i == maxNumberIndex) {
                maxNumberIndex = minNumberIndex;
            }
            buffer = array[array.length - 1 - i];
            array[array.length - 1 - i] = array[maxNumberIndex];
            array[maxNumberIndex] = buffer;
        }
    }
}
