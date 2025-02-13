package RecursionBasic;

public class SumofDigits {
    public static int sumOfDigits(int n) {
        if (n == 0)  // Base case
            return 0;
        return (n % 10) + sumOfDigits(n / 10);  // Recursive call
    }

    public static void main(String[] args) {
        int n = 12345;
        System.out.println("Sum of digits of " + n + " is: " + sumOfDigits(n));
        // Output: Sum of digits of 12345 is: 15
    }
}
