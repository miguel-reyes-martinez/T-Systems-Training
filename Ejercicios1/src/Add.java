public class Add extends Operation{



    public Add(double a, double b) {
        super(a, b);
    }

    @Override
    public double operate(){
        double result = a + b;
        return result;
    }
    
}
