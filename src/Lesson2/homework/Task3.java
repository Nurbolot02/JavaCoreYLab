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
        System.out.println(fuzzySearch("cwheeel", "cartwheel"));
        System.out.println(fuzzySearch("lw", "cartwheel"));
    }

    public static boolean fuzzySearch(String str1, String str2) {
        for (int i = 0, lastInd = 0; i < str1.length(); i++) {
            for (int j = lastInd; j < str2.length(); j++) {
                if (str1.length() - 1 == i && str1.charAt(i) == str2.charAt(j)) {
                    return true;
                }
                if (str1.charAt(i) == str2.charAt(j)) {
                    lastInd = j + 1;
                    break;
                } else if (j == str2.length() - 1) {
                    return false;
                }
            }
        }
        return false;
    }
}
