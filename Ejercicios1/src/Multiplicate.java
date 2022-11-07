public class Multiplicate extends Operation{



    public Multiplicate(double a, double b) {
        super(a, b);
    }

    @Override
    public double operate(){
        double result = a * b;
        return result;
    }
    
}
