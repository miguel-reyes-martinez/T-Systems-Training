import java.util.LinkedList;

public class Supermarket {
    private LinkedList<Product> stock = new LinkedList<Product>();


    public Supermarket() {
    }

    public void add(Product p){
        stock.add(p);
    }

    public void printStock(){
        for (Product p : stock) {
            System.out.println(String.format("\tNombre: "+p.getName()+" \tPrecio: "+ p.getPrice() +" \tCantidad: " + p.getCuantity()));
        }
    }

    public LinkedList<Product> getStock() {
        return this.stock;
    }

}
