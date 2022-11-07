public class Product {
    private double price = 0;
    int cuantity = 0;
    private String name = "placeholder";


    public Product(double price, String name, int cuantity) {
        this.price = price;
        this.name = name;
        this.cuantity = cuantity;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getCuantity() {
        return this.cuantity;
    }

    public void setCuantity(int cuantity) {
        this.cuantity = cuantity;
    }


}
