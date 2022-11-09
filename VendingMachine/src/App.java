public class App {
    public static void main(String[] args) throws Exception {
        
        VendingMachine myMachine = new VendingMachine();

        myMachine.add(new Product("Coca-Cola", 1.5, 10));
        myMachine.add(new Product("Nestea", 1.3, 5));
        myMachine.add(new Product("Agua", 1, 20));
        myMachine.add(new Product("Snack", 0.8, 3));

        
        try {
            
           Product p = myMachine.askForProduct();
           System.out.println("Salida máquina -> " + p.toString());
        } catch (Exception e) {
            System.out.println("[ERROR] - " + e.getMessage());
            System.out.println("Reiniciando máquina...");
            Thread.sleep(3000);
            myMachine.askForProduct();
        }

    }
}
