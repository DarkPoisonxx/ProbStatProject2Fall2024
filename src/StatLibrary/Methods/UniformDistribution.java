package StatLibrary.Methods;

public class UniformDistribution {
    double a; // Lower bound of the distribution
    double b; // Upper bound of the distribution

    // Default constructor
    public UniformDistribution() {}

    // Calculates the uniform probability density for the range [a, b]
    public double distribution(double a, double b) {
        this.a = a;
        this.b = b;
        return 1 / (b - a); // Formula: 1 / (b - a)
    }

    // Calculates the expected value (mean) for the uniform distribution
    public double expected() {
        return (a + b) / 2; // Formula: (a + b) / 2
    }
}
