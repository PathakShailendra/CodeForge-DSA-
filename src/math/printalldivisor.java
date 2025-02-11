package math;

public class printalldivisor {
    public static int sumOfDivisors(int n) {
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += (n/i)*i;
        }
        return sum;
    }
}
