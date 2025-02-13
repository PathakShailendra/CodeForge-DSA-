package RecursionBasic;

public class FactorialRecursion {
    public static int factorial(int n) {
        if (n == 0 || n == 1)  // Base case
            return 1;
        return n * factorial(n - 1);  // Recursive call
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Factorial of " + n + " is: " + factorial(n));
        // Output: Factorial of 5 is: 120
    }
}
