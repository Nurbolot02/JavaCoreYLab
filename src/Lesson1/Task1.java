package Lesson1;

import java.util.Random;

/**
 * A program fills 2d array randomly
 *
 * @author Nurbolot Gulamidinov
 * @version 1.0.0
 */
public class Task1 {
    /*
    1. Заполните двумерный массив случайным числами и выведите максимальное, минимальное и среднее значение.
     */
    public static void main(String[] args) {
        int arraySize = 4;
        int[][] array = new int[arraySize][arraySize];
        System.out.println("Default array");
        print(array);
        fill2DArrayRandom(array, 10);
        System.out.println("Random filled array");
        print(array);
        int maxNum = findMax(array);
        int minNum = findMin(array);
        double midNum = findMid(array);
        System.out.printf("max number - %d \nmid number - %s \nmin number - %d", maxNum, midNum, minNum);
    }

    /**
     * find mid-number in 2d array
     *
     * @param array 2d array
     * @return mid-number
     */
    public static double findMid(int[][] array) {
        double midNum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {

                midNum += array[i][j];
            }
        }
        return midNum / (array.length * array[0].length);
    }

    /**
     * find min number in 2d array
     *
     * @param array 2d array
     * @return min number
     */
    public static int findMin(int[][] array) {
        int minNum = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < minNum) {
                    minNum = array[i][j];
                }
            }
        }
        return minNum;
    }

    /**
     * find max number in 2d array
     *
     * @param array 2d array
     * @return max number
     */
    public static int findMax(int[][] array) {
        int maxNum = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > maxNum) {
                    maxNum = array[i][j];
                }
            }
        }
        return maxNum;
    }

    /**
     * fills a 2-dimensional array randomly
     *
     * @param array    2d array
     * @param maxValue max int value
     */
    public static void fill2DArrayRandom(int[][] array, int maxValue) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(1, maxValue);
            }
        }
    }

    /**
     * prints 2d array to console
     *
     * @param array 2d array
     */
    public static void print(int[][] array) {
        int arrayLength = array.length;
        for (int i = 0; i < arrayLength + 1; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < arrayLength; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
