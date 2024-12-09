package StatLibrary.Tests;

import StatLibrary.Methods.PoissonDistribution;

public class PoissonDistributionTest {
    public static void main(String[] args) {
        PoissonDistribution test = new PoissonDistribution();
        System.out.println(test.distribution(15.0, 20));
        System.out.println(test.expected());
    }
}
