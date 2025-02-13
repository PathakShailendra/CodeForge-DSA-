package math;

public class powxton {
    public double myPow(double x, int n) {
        long b = n; // Convert to long to prevent overflow
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        return powerHelper(x, b);
    }

    private static double powerHelper(double x, long n) {
        if (n == 0) return 1; // Base case
        double half = powerHelper(x, n / 2);

        if (n % 2 == 0) return half * half;  // Even exponent
        else return half * half * x;         // Odd exponent
    }
}
