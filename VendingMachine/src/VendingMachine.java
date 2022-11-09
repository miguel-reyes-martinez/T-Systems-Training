import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
    private Map<String, Product> productList = new HashMap<String, Product>();

    public void add(Product p) {
        productList.put(p.getName().toUpperCase(), p);
    }

    private Product getProduct(Product p, int cuantity) throws Exception {
        p.setStock(p.getStock() - cuantity);
        return new Product(p.getName(), p.getPrice(), cuantity);

    }

    private boolean checkStock(Product p, int cuantity) throws Exception {
        if (p.getStock() >= cuantity) {
            return true;
        } else {
            throw new Exception("No hay unidades de '" + p.getName() + "' suficientes.");
        }
    }

    public Product askForProduct() throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nIntroduzca saldo: ");
        double moneyAmount = Double.parseDouble(sc.nextLine());

        System.out.println("¿Qué producto desea?");

        productList.forEach((key, value) -> System.out.println("[" + key + "] " + "(" + value.getPrice() + " euro/s) "));
        System.out.print("Escriba el nombre del producto y la cantidad:\t");
        String[] choice = sc.nextLine().split(" ");

        if (choice.length != 2) {
            
            throw new Exception("Debe introducir: [PRODUCTO] [CANTIDAD]");
        } else {
            Product p = productList.get(choice[0].toUpperCase());
            int cuantity = Integer.parseInt(choice[1]);

            double totalPrice = (p.getPrice()*cuantity);

            if (checkStock(p, cuantity)) {
                if (totalPrice > moneyAmount) {
                    
                    throw new Exception("Saldo insuficiente - Introducido: "+moneyAmount+" Necesario: " + p.getPrice()*cuantity);
                }else{
                    if (totalPrice < moneyAmount) {
                        System.out.println("[CAMBIO] "+ (moneyAmount - totalPrice) +"euro/s");
                    }
                    
                    return getProduct(p, cuantity);
                }
            }
        }
        
        return null;
    }
}
