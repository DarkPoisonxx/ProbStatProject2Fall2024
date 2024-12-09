package StatLibrary.Methods;

public class UniformDistribution {
    double a;
    double b;
    public UniformDistribution(){

    }

    public double distribution(double a, double b){
        this.a = a;
        this.b = b;      
        return 1/ (a-b);
    }

    public double expected(){
        return (a + b) / 2;
    }
}
