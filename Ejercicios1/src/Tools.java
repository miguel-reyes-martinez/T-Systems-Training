import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Tools {

    private static int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }

    public static int getValueFromRomanNumber(String roman) {
        int result = 0;

        for (int i = 0; i < roman.length(); i++) {

            int firstChar = getValue(roman.charAt(i));
            if (i < roman.length() - 1) {
                int secondChar = getValue(roman.charAt(i + 1));
                if (firstChar < secondChar) {
                    result -= firstChar;
                } else {
                    result += firstChar;
                }

            } else {
                result += firstChar;
            }
        }

        return result;
    }

    public static long getDaysBetweenDates(String s1, String s2) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = LocalDate.parse(s1, dtf);
        LocalDate date2 = LocalDate.parse(s2, dtf);

        long daysBetween = ChronoUnit.DAYS.between(date1, date2);

        return daysBetween;
    }

    public static int getFibonacciRecursive(int number) {
        if (number <= 1){
            return number;
        }
        return getFibonacciRecursive(number - 1) + getFibonacciRecursive(number - 2);
    }

    public static int getFibonacciDinamic(int number) {

        int fibonacci[] = new int[number + 2];

        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2; i <= number; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        return fibonacci[number];
    }

}
