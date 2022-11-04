import java.util.ArrayList;

public class Tools {
    final static int[] RICE_TYPE = { 5, 3, 1 };
    
    public static boolean isPalindrome(String word) {
        boolean isPalindrome = true;
        word = word.toLowerCase();

        for (int i = 0, j = word.length() - 1; i < word.length() / 2; i++, j--) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
        }
        return isPalindrome;
    }

    public static boolean isPalindrome(int number) {
        return isPalindrome(Integer.toString(number));
    }

    public static int getFactorial(int number) {

        if (number == 0) {
            return 1;
        } else {
            return number * getFactorial(number - 1);
        }
    }

    /*
     * Repaso del algoritmo de Euclides:
     * El máximo común divisor (MCD) de dos enteros A y B es el entero más grande
     * que divide tanto a A como a B.
     * Si A = 0 entonces MCD( A, B ) = B, lo mismo al revés.
     * Escribe A en la forma cociente y residuo (A = B ⋅Q + R).
     * Encuentra MCD(B,R) al usar el algoritmo de Euclides, ya que MCD(A,B) =
     * MCD(B,R).
     */

    public static int GreatestCommonDivisor(int a, int b) {
        if (b == 0)
            return a;
        else
            return GreatestCommonDivisor(b, a % b);
    }

    public static boolean isArmstrong(int number) {
        int originalNumber = number;
        int armstrongNumber = 0;
        int power = String.valueOf(originalNumber).length();
        while (number > 0) {
            int remainder = number % 10;
            armstrongNumber += Math.pow(remainder, power);
            number /= 10;
        }
        return (armstrongNumber == originalNumber) ? true : false;
    }

    public static String ReverseString(String s) {
        String reversedString = "";
        for (int i = s.length() - 1; i >= 0; i--) {

            reversedString += s.charAt(i);
        }
        return reversedString;
    }

    public static ArrayList<Integer> RicePackages(int kilograms) {
        
        ArrayList<Integer> packages = new ArrayList<Integer>(RICE_TYPE.length);

        for (int i = 0; i < RICE_TYPE.length; i++) {

            int numberOfPackages = kilograms / RICE_TYPE[i];
            if (numberOfPackages > 0) {
                packages.add(numberOfPackages);
                kilograms -= numberOfPackages * RICE_TYPE[i];
            }

        }
        return packages;
    }

}