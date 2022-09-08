package Lesson2.homework;

public class Task3 {
    /*
    Реализовать функцию нечеткого поиска
    fuzzySearch("car", "ca6$$#_rtwheel"); // true
    fuzzySearch("cwhl", "cartwheel"); // true
    fuzzySearch("cwhee", "cartwheel"); // true
    fuzzySearch("cartwheel", "cartwheel"); // true
    fuzzySearch("cwheeel", "cartwheel"); // false
    fuzzySearch("lw", "cartwheel"); // false
     */
    public static void main(String[] args) {
        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel"));
        System.out.println(fuzzySearch("cwhl", "cartwheel"));
        System.out.println(fuzzySearch("cwhee", "cartwheel"));
        System.out.println(fuzzySearch("cartwheel", "cartwheel"));
        System.out.println(fuzzySearch("cwheeel", "cartwheel")); // 4 5 6 7
        System.out.println(fuzzySearch("lw", "cartwheel"));
    }

    public static boolean fuzzySearch(String str1, String str2) {
        if (str1 == null || str2 == null) throw new NullPointerException("Null link!");
        int i, j;
        for (i = 0, j = 0; j < str1.length(); i++, j++) {
            i = (str2.substring(i).indexOf(str1.charAt(j)) != -1 ? str2.substring(i).indexOf(str1.charAt(j)) + i : -1);
            if (i == -1) return false;
        }
        return i != -1;
    }
}
