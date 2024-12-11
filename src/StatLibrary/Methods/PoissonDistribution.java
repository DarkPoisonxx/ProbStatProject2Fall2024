package StatLibrary.Methods;

public class PoissonDistribution {
    private double lambda; // Average rate of occurrences (lambda)
    private BigIntFactorial factorial = new BigIntFactorial(); // Helper for factorial calculations

    // Default constructor
    public PoissonDistribution() {}

    
     // Calculates the Poisson probability for a given lambda and x.     
    public double distribution(double lambda, int x) {
        this.lambda = lambda;
        return (Math.pow(Math.E, -lambda) * Math.pow(lambda, x)) / (factorial.factorial(x).doubleValue());
    }
    
    // Returns the expected value (mean), which equals lambda.   
    public double expected() {
        return this.lambda;
    }

     //Returns the variance, which is also equal to lambda.
    public double variance() {
        return this.lambda;
    }
}
