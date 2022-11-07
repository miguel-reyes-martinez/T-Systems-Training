import java.util.Scanner;

public class Calculator {

    public Calculator() {
    }

    public double operate(Operation operation) {
        try {
            return operation.operate();
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
            return 0;
        }
        
    }
}
