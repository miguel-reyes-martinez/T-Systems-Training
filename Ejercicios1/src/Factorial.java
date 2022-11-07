public class Factorial extends Operation{



    public Factorial(double a) {
        super(a, 0);
    }

    @Override
    public double operate(){
        double result = 1;
        while ( a!=0) {
            result=result*a; 
            a--;
        }
        
        return result;
    }
    
}
