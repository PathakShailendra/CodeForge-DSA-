package BitManipulation;

public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        // Step 1: Handle overflow edge case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Step 2: Convert to long and take absolute values
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        int result = 0;

        // Step 3: Subtract divisor in powers of two using bit shifts
        while (dvd >= dvs) {
            long temp = dvs;
            int multiple = 1;

            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            dvd -= temp;
            result += multiple;
        }

        // Step 4: Apply sign (positive or negative)
        if ((dividend > 0) == (divisor > 0)) {
            return result;
        } else {
            return -result;
        }
    }

    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 3;
        System.out.println("Quotient: " + divide(dividend, divisor)); // Output: 3
    }
}
