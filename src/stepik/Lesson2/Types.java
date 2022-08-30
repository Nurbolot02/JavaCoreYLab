package stepik.Lesson2;

import java.util.Arrays;

public class Types {
    public static void main(String[] args) {
        String str = "A" + ('\t' + '\u0003');
        System.out.println(str);
        String s2 = "A" + 12;
        System.out.println(s2);
        String s3 = 'A' + '1' + "2";
        System.out.println(s3);
        String s4 =  'A' + "12";
        System.out.println(s4);

        int[] ar = new int[0];
    }
}
