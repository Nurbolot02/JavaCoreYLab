package stepik.Lesson2;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;

public class Task2_4Last {
    public static void main(String[] args) throws InterruptedException {
        /*
        Вам дан список ролей и сценарий пьесы в виде массива строчек.
        Каждая строчка сценария пьесы дана в следующем виде:
        Роль: текст

        Текст может содержать любые символы.

        Напишите метод, который будет группировать строчки по ролям, пронумеровывать их и возвращать результат в виде готового текста (см. пример).
        Каждая группа распечатывается в следующем виде:

        Роль:
        i) текст
        j) текст2
        ...
        ==перевод строки==

        i и j -- номера строк в сценарии. Индексация строчек начинается с единицы, выводить группы следует в соответствии с порядком ролей.
        Переводы строк между группами обязательны, переводы строк в конце текста не учитываются.

        Заметим, что вам предстоит обработка огромной пьесы в 50 000 строк для 10 ролей – соответственно,
         неправильная сборка результирующей строчки может выйти за ограничение по времени.

        Обратите внимание еще на несколько нюансов:

        имя персонажа может встречаться в строке более одного раза, в том числе с двоеточием;
        название одной роли может быть префиксом названия другой роли (например, "Лука" и "Лука Лукич");
        роль, у которой нет реплик, тоже должна присутствовать в выходном файле;
        в качестве перевода строки надо использовать символ '\n' (перевод строки в стиле UNIX);
        будьте внимательны, не добавляйте лишних пробелов в конце строк.
        Sample Input:

        roles:
        Городничий
        Аммос Федорович
        Артемий Филиппович
        Лука Лукич
        textLines:
        Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.
        Аммос Федорович: Как ревизор?
        Артемий Филиппович: Как ревизор?
        Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.
        Аммос Федорович: Вот те на!
        Артемий Филиппович: Вот не было заботы, так подай!
        Лука Лукич: Господи боже! еще и с секретным предписаньем!
        Sample Output:

        Городничий:
        1) Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.
        4) Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.

        Аммос Федорович:
        2) Как ревизор?
        5) Вот те на!

        Артемий Филиппович:
        3) Как ревизор?
        6) Вот не было заботы, так подай!

        Лука Лукич:
        7) Господи боже! еще и с секретным предписаньем!
         */
        String[] roles = {"Nurbolot", "Городничий", "Аммос Федорович", "Артемий Филиппович", "Лука Лукич"};
        String[] textLines = {"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                        "Аммос Федорович: Как ревизор?",
                        "Артемий Филиппович: Как ревизор?",
                        "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                        "Аммос Федорович: Вот те на!",
                        "Артемий Филиппович: Вот не было заботы, так подай!",
                        "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};




        long start = System.nanoTime();
        // выполнение какой-то логики
        String result = printTextPerRole(roles, textLines);
        long finish = System.nanoTime();
        long elapsed = finish - start;
        System.out.println("Прошло времени, мс: " + elapsed);

        long start2 = System.nanoTime();
        String result1 = printTextPerRole1(roles, textLines);
        long finish2 = System.nanoTime();
        long allTime = finish2 - start2;
        System.out.println("Прошло времени, мс: " + allTime);


    }

    private static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < roles.length; i++) {
            stringBuilder.append(roles[i]);
            stringBuilder.append(":");
            stringBuilder.append('\n');
            for (int j = 0; j < textLines.length; j++) {
                if (roles[i].equals(textLines[j].substring(0, textLines[j].indexOf(":")))){
                    stringBuilder.append(j + 1);
                    stringBuilder.append(")");
                    stringBuilder.append(textLines[j].substring(textLines[j].indexOf(":") + 1, textLines[j].length()));
                    stringBuilder.append('\n');
                }
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }


    private static String printTextPerRole1(String[] roles, String[] textLines) {
        StringBuilder[] rolesWithText = new StringBuilder[roles.length];
        for (int i = 0; i<roles.length; i++) {
            rolesWithText[i] = new StringBuilder(roles[i] + ":\n");
        }

        for (int i = 0; i<textLines.length; i++) {
            for (int j = 0; j<roles.length; j++) {
                if (textLines[i].startsWith(roles[j] + ":")) {
                    rolesWithText[j].append(textLines[i].replaceFirst(roles[j] + ":", (i+1) + ")") + "\n");
                    break;
                }
            }
        }
        StringBuilder output = new StringBuilder("");
        for (StringBuilder r: rolesWithText) {
            output.append(r+"\n");
        }
        return output.toString();
    }

    private static String printTextPerRole3(String[] roles, String[] textLines) {
        HashMap<String, StringBuilder> hash = new HashMap<String, StringBuilder>();
        for(String name : roles) {
            hash.put(name, new StringBuilder());
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < textLines.length; i++) {
            int border = textLines[i].indexOf(':');
            String key = textLines[i].substring(0, border);
            hash.get(key).append((i + 1)).append(")")
                    .append(textLines[i].substring(border + 1, textLines[i].length())).append("\n");
        }

        for (String name : roles) {
            result.append(name).append(":\n");
            result.append(hash.get(name));
            result.append("\n");
        }
        return result.toString();
    }


}
