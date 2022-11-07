import java.util.LinkedList;

public class Supermarket {
    private LinkedList<Product> stock = new LinkedList<Product>();


    public Supermarket() {
    }

    public void add(Product p){
        stock.add(p);
    }

    

    @Override
    public String toString(){
        String result = "";
        for (Product p : stock) {
            result += "\tNombre: "+p.getName()+" \tPrecio: "+ p.getPrice() +" \tCantidad: " + p.getCuantity() + "\n";
        }
        return result;
    }

    public LinkedList<Product> getStock() {
        return this.stock;
    }

}
