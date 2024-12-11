package StatLibrary.Tests;

import StatLibrary.Methods.UniformDistribution;

public class UniformDistributionTest {
    public static void main(String[] args) {
        // Create an instance of the UniformDistribution class
        UniformDistribution test = new UniformDistribution();

        // Test the distribution method with a = 15.0 and b = 20.0
        System.out.println(test.distribution(15.0, 20.0));

        // Test the expected value calculation
        System.out.println(test.expected());
    }
}
