import java.util.ArrayList;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("\n- - - Ejercicio 1 - - -");
        /*
         * Ejercicio 1: Dado un string, comprobar si es palíndromo o no
         * 
         * Cambiar la variable 'word' para probar con diferentes palabras
         * 
         */
        String word = "patata";

        if (Tools.isPalindrome(word)) {
            System.out.println(String.format("\t¡La palabra %s es un palindromo!", word));
        } else {
            System.out.println(String.format("\t¡Oh! La palabra %s no es un palindromo", word));
        }

        System.out.println("\n- - - Ejercicio 2 - - -");
        /*
         * Ejercicio 2: Dado un número, comprobar si es palíndromo o no
         * 
         * Cambiar la variable 'number' para probar con diferentes números
         * 
         */

        int numberToCheckPalindrome = 11511;

        if (Tools.isPalindrome(numberToCheckPalindrome)) {
            System.out.println(String.format("\t¡El número %s es un palindromo!", numberToCheckPalindrome));
        } else {
            System.out.println(String.format("\t¡Oh! El número %s no es un palindromo", numberToCheckPalindrome));
        }

        System.out.println("\n- - - Ejercicio 3 - - -");
        /*
         * Ejercicio 3: Dado un número entero, calcular su factorial
         * 
         * Cambiar la variable 'numberToGetFactorial' para probar con diferentes números
         * 
         */
        int numberToGetFactorial = 4;
        int factorial = Tools.getFactorial(numberToGetFactorial);

        System.out.println(String.format("\tEl factorial de %d es igual a %d", numberToGetFactorial, factorial));

        System.out.println("\n- - - Ejercicio 4 - - -");
        /*
         * Ejercicio 4: Dados dos números, calcular su máximo común divisor
         * 
         * Cambiar las variables 'numberA' y 'numberB' para probar distintos resultados.
         * 
         */
        int numberA = 50;
        int numberB = 5;
        int gcd = Tools.GreatestCommonDivisor(numberA, numberB);

        System.out.println(String.format("\tEl MCD de %d y %d es %d", numberA, numberB, gcd));

        System.out.println("\n- - - Ejercicio 5 - - -");
        /*
         * Ejercicio 5: Comprobar si un número es un número de Armstrong
         * 
         * Cambiar la variable 'numberToGetFactorial' para probar con diferentes números
         * 
         */

        int numberToCheckArmstrong = 371;

        if (Tools.isArmstrong(numberToCheckArmstrong)) {
            System.out.println(String.format("\t¡El número %s es un número de Armstrong!", numberToCheckArmstrong));
        } else {
            System.out.println(String.format("\t¡Oh! El número %s no es un número de Armstrong", numberToCheckArmstrong));
        }

        System.out.println("\n- - - Ejercicio 6 - - -");
        /*
         * Ejercicio 6: Dado un string, darle la vuelta sin utilizar el método reverse
         * 
         * 
         * Cambiar la variable 'originalString' para probar con diferentes frases
         * 
         */
        String originalString = "Hello world!";
        System.out.println(String.format("\tSentencia original: %s", originalString));
        String reversedString = Tools.ReverseString(originalString);
        System.out.println(String.format("\tSentencia invertida: %s", reversedString));

        System.out.println("\n- - - Ejercicio 7 - - -");
        /*
         * Ejercicio 7: Tenemos paquetes de arroz de 1, 3 y 5 Kilos.
         * Calcular el mínimo número de paquetes de arroz que necesitamos
         * para igualar un peso pasado por parámetro. Lanzar una excepción
         * si no podemos cumplirlo :)
         * 
         *  Cambiar 'riceKilograms' para probar distintos resultados
         */
        int riceKilograms = 34;
        ArrayList<Integer> ricePackages = Tools.RicePackages(riceKilograms);

        System.out.println(String.format("\tNúmero de kilos total: %d", riceKilograms));

        for (int i = 0; i < ricePackages.size(); i++) {
            System.out.println("\tPaquetes de " + Tools.RICE_TYPE[i] + " kilos: " + ricePackages.get(i));
        }

    }
}
