package neural;

public class Activation {
    public static double sigmoid(double sum) {
        return 1.0 / (1 + Math.exp(-1.0 * sum));
    }
}
