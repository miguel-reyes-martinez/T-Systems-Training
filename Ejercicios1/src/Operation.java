public abstract class Operation {
    double a;
    double b;
    

    public Operation(double a, double b) {
        this.a = a;
        this.b = b;
    }


    public double operate() throws Exception{
        return 0;
    }
    
}
