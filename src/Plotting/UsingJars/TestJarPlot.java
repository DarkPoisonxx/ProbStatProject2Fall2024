package Plotting.UsingJars;
public class TestJarPlot {
    public static void main(String[] args) {
        // Create an instance of JarPlotter and call plot
        jarPlotter plotter = new jarPlotter();
        plotter.plotBase(-12, 10, 100);  // Example usage with 0 to 2π and 100 points
        plotter.salt(20);
        plotter.smooth();
        plotter.smooth();
        plotter.smooth();plotter.smooth();
    }
}
