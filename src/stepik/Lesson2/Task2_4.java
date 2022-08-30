package stepik.Lesson2;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class Task2_4 {
    public static void main(String[] args) {
        boolean weatherIsGood = getWeather();

        System.out.println("Weather is " + (weatherIsGood ? "good" : "bad"));

        Random random = new Random();
        switch (random.nextInt()) {
            case 1:
                System.out.println(1);
            case 2:
                System.out.println(2);
            case 3:
                System.out.println(3);
                break;
            case 4:
                System.out.println(4);
            default:
                System.out.println("default");
        }


        for (int i = 0; i < 100; i++) {
            // тело цикла
            System.out.print(i + " ");
            continue;
        }
        System.out.println();
        for (int i = 0; i < 100; ) {
            // тело цикла
            System.out.print(i + " ");
            i++;
            continue;

        }
        System.out.println();

        System.out.println(factorial(4));
        System.out.println(Arrays.toString(mergeArrays(new int[]{0, 2, 2}, new int[]{1, 3})));
        ;


    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] array = new int[a1.length + a2.length];
        for (int i = 0; i < a1.length; i++) {
            array[i] = a1[i];
        }
        for (int i = a1.length, j = 0; i < a1.length + a2.length; i++, j++) {
            array[i] = a2[j];
        }
        Arrays.sort(array);
        return array; // your implementation here
    }

    public static BigInteger factorial(int value) {
        BigInteger ret = BigInteger.ONE;
        for (int i = 1; i <= value; i++) {
            ret = ret.multiply(factorial(value - 1));
        }
        return ret; // your implementation here
    }

    /**
     * @return
     */
    public static boolean getWeather() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
