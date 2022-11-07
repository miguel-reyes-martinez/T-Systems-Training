public class Subtract extends Operation{



    public Subtract(double a, double b) {
        super(a, b);
    }

    @Override
    public double operate(){
        double result = a - b;
        return result;
    }
    
}