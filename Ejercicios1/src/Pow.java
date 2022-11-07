public class Pow extends Operation{



    public Pow(double a, double b) {
        super(a, b);
    }

    @Override
    public double operate(){
        double result = Math.pow(a, b);
        return result;
    }
    
}
