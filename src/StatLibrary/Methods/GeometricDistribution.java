package StatLibrary.Methods;

public class GeometricDistribution {

    
     // This method calculates the probability of the first success happening on the k-th trial.
     // It's based on the geometric distribution formula.
     // parameter k The trial number where we're expecting the first success (must be at least 1).
     //parameter p The probability of success on a single trial (should be between 0 and 1).
     //return The probability of the first success occurring on the k-th trial.
     
    public double geometricProbability(int k, double p) {
        // Validate the inputs to ensure they're reasonable
        if (k < 1 || p <= 0 || p > 1) {
            throw new IllegalArgumentException("invalid inputs Please try again");
        }
        // Use the geometric probability formula: (1 - p)^(k-1) * p
        return Math.pow(1 - p, k - 1) * p;
    }

}
