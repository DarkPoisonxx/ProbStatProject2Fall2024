package StatLibrary.Tests;

import StatLibrary.Methods.PoissonDistribution;

public class PoissonDistributionTest {
    public static void main(String[] args) {
        // Create an instance of the PoissonDistribution class
        PoissonDistribution test = new PoissonDistribution();

        // Test the distribution method with lambda = 15.0 and x = 20
        System.out.println(test.distribution(15.0, 20));

        // Print the expected value (mean), which should match lambda
        System.out.println(test.expected());
    }
}
