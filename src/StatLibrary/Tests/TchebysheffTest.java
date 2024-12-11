package StatLibrary.Tests;
import StatLibrary.Methods.Tchebysheff;

public class TchebysheffTest {
    public static void main(String[] args) {
        // Create an instance of the Tchebysheff class
        Tchebysheff test = new Tchebysheff();

        // Test the tchebysheff method with k = 10 and print the result
        System.out.println(test.tchebysheff(10));
    }
}
