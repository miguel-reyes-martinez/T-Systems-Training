import javax.naming.spi.DirStateFactory.Result;

public class Divide extends Operation{



    public Divide(double a, double b) {
        super(a, b);
    }

    @Override
    public double operate() throws Exception{
        double result = 0;
        if (b == 0) {
            throw new ArithmeticException("No se puede dividdir por 0.");
        }else{

        }
        return result;
    }
    
}
