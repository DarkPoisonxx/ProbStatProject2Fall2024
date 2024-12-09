package StatLibrary.Methods;

public class PoissonDistribution {
    private double lambda;
    private BigIntFactorial factorial = new BigIntFactorial();
    
    public PoissonDistribution(){

    }
    public double distribution(double lambda ,int x){
        this.lambda = lambda;
        double product = (Math.pow(Math.E, -lambda) * Math.pow(lambda, x)) / (factorial.factorial(x).doubleValue());
        return product;
    }

    public double expected(){
        return this.lambda;
    }

    public double variance(){
        return this.lambda;
    }
}
