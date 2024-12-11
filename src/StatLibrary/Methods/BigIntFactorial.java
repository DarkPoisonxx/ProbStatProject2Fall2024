package StatLibrary.Methods;

import java.math.BigInteger;

public class BigIntFactorial {
    
    // Default constructor
    public BigIntFactorial() {}

    
     //Calculates the factorial of a given number using BigInteger.
     //parameter input The number for which the factorial is calculated.
     // return The factorial as a BigInteger.
    public BigInteger factorial(int input) {
        BigInteger product = BigInteger.valueOf(input);
        
        // Return 1 for factorial of 0
        if (product.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }

        // Multiply numbers from input down to 1
        for (int i = input - 1; i > 0; i--) {
            product = product.multiply(BigInteger.valueOf(i));
        }
        return product;
    }
}
