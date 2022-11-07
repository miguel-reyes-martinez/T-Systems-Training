import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.TimeZone;

public class App {

    public static HashSet<String> countWords(String sentence) {
        HashSet<String> hashSet = new HashSet<String>();

        sentence = sentence.toLowerCase();
        sentence = sentence.replace(".", "");
        String splittedSentence[] = sentence.split(" ");

        for (String s : splittedSentence) {
            hashSet.add(s);
        }

        return hashSet;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("\n- - - Ejercicio 1 - - -");
        /*
         * Ejercicio 1: Dado un número en romano, pasarlo a decimal
         * 
         * Cambiar la variable 'romanNumber' para probar con diferentes números
         * 
         */
        String romanNumber = "MCCXCIV";
        int decimalNumber = Tools.getValueFromRomanNumber(romanNumber);
        System.out
                .println(String.format("\tEl numero romano %s es igual a %d en decimal.", romanNumber, decimalNumber));

        System.out.println("\n- - - Ejercicio 2 - - -");
        /*
         * Crear una función que devuelva los días entre dos fechas. Las fechas
         * vendrán indicadas por un string con formato “dd/MM/yyyy”
         * 
         * Cambiar las variables 'date1' y 'date2' para probar con diferentes fechas
         * 
         */
        String date1 = "20/05/2022";
        String date2 = "25/05/2022";

        long daysBetween = Tools.getDaysBetweenDates(date1, date2);
        System.out
                .println(String.format("\tEl número de dias entre %s - %s es igual a %d.", date1, date2, daysBetween));

        System.out.println("\n- - - Ejercicio 3.1 - - -");
        /*
         * Crea un paquete que provea de los métodos para trabajar con Shapes
         * 
         * - Crear clases para Rectangle, Circle, Square and Triangle
         * 
         * - Todas las clases tienen que tener un método para devolver su área y
         * perímetro
         * 
         * - Intenta escribir el menor código posible (herencia…)
         */
        Square square = new Square(5);
        Rectangle rectangle = new Rectangle(4, 2);
        Triangle triangle = new Triangle(5, 3);
        Circle circle = new Circle(3);

        System.out.println(String.format("\tÁrea cuadrado: %f \t Perimetro cuadrado: %f", square.getArea(),
                square.getPerimeter()));
        System.out.println(String.format("\tÁrea rectángulo: %f \t Perimetro rectángulo: %f", rectangle.getArea(),
                rectangle.getPerimeter()));
        System.out.println(String.format("\tÁrea triángulo: %f \t Perimetro triángulo: %s", triangle.getArea(), "WIP"));
        System.out.println(
                String.format("\tÁrea círculo: %f \t Perimetro círculo: %f", circle.getArea(), circle.getPerimeter()));

        System.out.println("\n- - - Ejercicio 3.2 - - -");
        /*
         * Obtener el valor para el n-ésimo valor de Fibonacci
         * - Recursivamente
         * - Con programación dinámica
         * 
         * Cambiar la variable 'fibonacciPosition' para probar con diferentes
         * resultados.
         * 
         */
        int fibonacciPosition = 9;
        System.out.println(String.format("\t(Recursivo) El valor %d de la sucesión de Fibonacci es: %d",
                fibonacciPosition, Tools.getFibonacciRecursive(fibonacciPosition)));
        System.out.println(String.format("\t(Dinámico) El valor %d de la sucesión de Fibonacci es: %d",
                fibonacciPosition, Tools.getFibonacciDinamic(fibonacciPosition)));

        System.out.println("\n- - - Ejercicio 4 - - -");
        /*
         * Crear una clase que nos permita guardar distintos tipos de productos en
         * un supermercado
         * 
         * Cada producto tiene que tener su precio y nombre
         * 
         */
        Product p1 = new Product(0.99,"Pen", 20);
        Product p2 = new Product(2.99,"Bottle", 5);
        Product p3 = new Product(2,"Apple", 7);
        Product p4 = new Product(9.99,"Shirt", 14);

        Supermarket market = new Supermarket();
        market.add(p1);
        market.add(p2);
        market.add(p3);
        market.add(p4);

        market.printStock();

        System.out.println("\n- - - Ejercicios aparte - - -");
        /*
         * Ejercicio contar palabras
         */

        String sentence = "Manzana mango pera manzana mango mango pera uva.";

        HashSet<String> result = countWords(sentence);
        System.out.println("La frase (" + sentence + ") tiene " + result.size() + " palabras únicas:");
        for (String s : result) {
            System.out.println("\t- " + s);
        }

        System.out.println("\n- - - - - - - - -");
        GregorianCalendar spainCalendar = new GregorianCalendar(new Locale("ES", "es"));
        GregorianCalendar losAngelesCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT-7"));

        System.out.println(
                "Hora en España: " + spainCalendar.get(Calendar.HOUR) + ":" + spainCalendar.get(Calendar.MINUTE));
        System.out.println("Hora en Los Ángeles: " + losAngelesCalendar.get(Calendar.HOUR) + ":"
                + losAngelesCalendar.get(Calendar.MINUTE));

    }
}
