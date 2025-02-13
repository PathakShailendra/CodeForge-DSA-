package RecursionBasic;

public class GCD_Euclidean {
    public static int gcd(int a, int b) {
        if (b == 0) return a;  // Base case
        return gcd(b, a % b);  // Recursive call
    }

    public static void main(String[] args) {
        int a = 36, b = 60;
        System.out.println("GCD of " + a + " and " + b + " is: " + gcd(a, b));
    }
}
