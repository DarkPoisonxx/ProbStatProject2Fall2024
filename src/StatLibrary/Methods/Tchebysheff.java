package StatLibrary.Methods;

public class Tchebysheff {

    
     // Calculates Tchebysheff's bound for a given k.
     // parameter x The number of standard deviations (k).
     // return The minimum proportion of values within k standard deviations.
    public double tchebysheff(double x) {
        return 1 - (1 / Math.pow(x, 2));
    }
}
