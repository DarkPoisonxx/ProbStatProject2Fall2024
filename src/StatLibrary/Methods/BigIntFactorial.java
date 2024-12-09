package StatLibrary.Methods;

import java.math.BigInteger;

public class BigIntFactorial{
    public BigIntFactorial(){
        
    }

    public BigInteger factorial(int input){
        BigInteger product = BigInteger.valueOf(input);
        if(product == BigInteger.valueOf(0)){
            return BigInteger.valueOf(0);
        }
        for (int i = input; i > 0; i--){
            product = product.multiply(BigInteger.valueOf(i)) ;
        }
        return product;
    }
}