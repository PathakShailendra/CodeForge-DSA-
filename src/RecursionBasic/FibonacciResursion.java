package RecursionBasic;

public class FibonacciResursion {
    public static int fib(int n) {
        if (n == 0) return 0;  // Base case
        if (n == 1) return 1;  // Base case
        return fib(n - 1) + fib(n - 2);  // Recursive call
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Fibonacci number at position " + n + " is: " + fib(n));
        // Output: Fibonacci number at position 5 is: 5
    }
}
