package testPackage.lesson7;

public class StringUtils {

    // метод, который принимает входящим параметром email
    // делает проверку на валидацию
    // и пишет на консоль корректный это email или нет
    public static void checkValidMail(String email) {
        /** 1) Проверяем содержание собачки. Если ее нет - НЕ ВАЛИДНЫЙ.
         *  2) Проверяем, что собачка только одна. Если нет - НЕ ВАЛИДНЫЙ
         *  3) Стоит не в начале, и не в конце. Если нет - НЕ ВАЛИДНЫЙ
         *  4) Должна быть хотя бы одна точка после @
         *  5) Точка после собачки, не может быть в начали или в конце
         *  // добавить разные проверки на emailл
         */

        if (!email.contains("@")) {
            System.out.println("Не содержит собачку!!!");
            return;
        }

        String[] partsOfEmail = email.split("@");
        if (partsOfEmail.length > 2) {
            System.out.println("Собаче больше одной!!!");
            return;
        }

        if (email.startsWith("@") || email.endsWith("@")) {
            System.out.println("Email не может начинаться или заканчиваться с собачки!!!");
            return;
        }

        String lastPart = partsOfEmail[1];
        if (!lastPart.contains(".")) {
            System.out.println("Email не содержит точку во второй части после собачки!!!");
            return;
        }

        System.out.println("Эмаил подходит!!!");
    }
}
