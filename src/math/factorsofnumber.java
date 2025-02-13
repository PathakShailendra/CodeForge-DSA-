package math;

public class factorsofnumber {
    public static void main(String[] args) {
        int n = 36;
        System.out.print("Factors: ");
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                if (i != n / i) { // Avoid duplicate factors (for perfect squares)
                    System.out.print(n / i + " ");
                }
            }
        }
    }
}
