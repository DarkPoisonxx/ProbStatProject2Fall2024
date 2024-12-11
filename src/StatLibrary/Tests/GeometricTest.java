package StatLibrary.Tests;
import StatLibrary.Methods.GeometricDistribution;
public class GeometricTest {
    public static void main(String[] args) {
        // Let's assume we want the first success on the 3rd trial
        int k = 3; // Trial number
        double p = 0.4; // Each trial has a 40% chance of success
        GeometricDistribution test = new GeometricDistribution();
        // Call the method to calculate the probability
        double probability = test.geometricProbability(k, p);

        // Print the result in a clear way
        System.out.println("The probability of the first success on trial " + k + " is: " + probability);
    }
}
