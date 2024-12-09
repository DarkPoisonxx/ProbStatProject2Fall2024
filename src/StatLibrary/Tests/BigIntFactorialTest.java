package StatLibrary.Tests;

import StatLibrary.Methods.BigIntFactorial;

public class BigIntFactorialTest{
    public static void main(String[] args) {
        BigIntFactorial test = new BigIntFactorial();
        System.out.println(test.factorial(10));
    }
}