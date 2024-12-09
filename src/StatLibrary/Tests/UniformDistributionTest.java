package StatLibrary.Tests;

import StatLibrary.Methods.UniformDistribution;

public class UniformDistributionTest {
    public static void main(String[] args) {
        UniformDistribution test = new UniformDistribution();
        System.out.println(test.distribution(15.0, 20));
        System.out.println(test.expected());
    }
}
