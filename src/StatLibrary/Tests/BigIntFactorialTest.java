package StatLibrary.Tests;

import StatLibrary.Methods.BigIntFactorial;

public class BigIntFactorialTest {
    public static void main(String[] args) {
        // Create an instance of the BigIntFactorial class
        BigIntFactorial test = new BigIntFactorial();

        // Test the factorial method with input 10 and print the result
        System.out.println(test.factorial(10));
    }
}
