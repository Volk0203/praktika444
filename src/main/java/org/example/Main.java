import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String str = scanner.nextLine();
        System.out.print("Введите подстроку: ");
        String substr = scanner.nextLine();
        int count = countSubstring(str, substr);
        System.out.println("Подстрока встречается " + count + " раз");
        System.out.print("Введите строку: ");
        str = scanner.nextLine();
        str = replaceCensoredWords(str);
        System.out.println("Измененная строка: " + str);
        System.out.print("Введите строку с датой (формат: 31.12.2020): ");
        str = scanner.nextLine();
        str = convertDate(str);
        System.out.println("Измененный формат даты: " + str);
    }
    public static int countSubstring(String str, String substr) {
        int count = 0;
        int index = str.indexOf(substr);
        while (index != -1) {
            count++;
            index = str.indexOf(substr, index + substr.length());
        }
        return count;
    }
    public static String replaceCensoredWords(String str) {
        str = str.replaceAll("кака", "вырезано цензурой");
        str = str.replaceAll("бяка", "вырезано цензурой");
        return str;
    }
    public static String convertDate(String str) {
        String[] parts = str.split("\\.");
        if (parts.length == 3) {
            return parts[2] + "-" + parts[1] + "-" + parts[0];
        } else {
            return "Некорректный формат даты";
        }
    }
    public static String convertDateUsingDateClass(String str) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = inputFormat.parse(str);
            return outputFormat.format(date);
        } catch (Exception e) {
            return "Некорректный формат даты";
        }
    }
}
