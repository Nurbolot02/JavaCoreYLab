package stepik.Lesson2;

/**
 * @author Nurbolot Gulamidinov
 * @version 1.0.0
 */

public class Task2_3 {
    /*
    Реализуйте метод, проверяющий, является ли заданная строка палиндромом.
    Палиндромом называется строка, которая читается одинаково слева направо и справа налево (в том числе пустая).
    При определении "палиндромности" строки должны учитываться только буквы и цифры.
    А пробелы, знаки препинания, а также регистр символов должны игнорироваться.
    Гарантируется, что в метод попадают только строки, состоящие из символов ASCII (цифры, латинские буквы, знаки препинания).
    Т.е. русских, китайских и прочих экзотических символов в строке не будет.
    Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода добавит проверяющая система.

    Sample - Madam, I'm Adam!
     */
    public static void main(String[] args) {
        String sample = "Madam, I'm Adam!";
        System.out.println(isPalindrome(sample));
    }

    /**
     * check isPalindrome
     *
     * @param text - text
     * @return true of false
     */

    public static boolean isPalindrome(String text) {
        String[] dontUseSymbols = {".", ",", "?", "!", ":", "-", "(", ")", " ", "'"};
        for (int i = 0; i < dontUseSymbols.length; i++) {
            text = text.replace(dontUseSymbols[i], "");
        }

        for (int i = 0; i < text.length(); i++) {
            if (!String.valueOf(text.charAt(i)).equalsIgnoreCase(String.valueOf(text.charAt(text.length() - 1 - i)))) {
                return false;
            }
        }
        return true;
    }
}
