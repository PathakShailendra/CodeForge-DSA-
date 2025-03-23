package BackTracking;

public class StringToIntegerAtoi {
        public int myAtoi(String s) {
            if (s == null || s.isEmpty()) return 0;

            s = s.trim();
            if (s.isEmpty()) return 0;

            int sign = 1;
            int index = 0;

            if (s.charAt(0) == '-' || s.charAt(0) == '+') {
                sign = (s.charAt(0) == '-') ? -1 : 1;
                index++;
            }

            return helper(s, index, 0, sign);
        }

        private int helper(String s, int index, long result, int sign) {
            if (index >= s.length() || !Character.isDigit(s.charAt(index))) {
                return (int) result * sign;
            }

            int digit = s.charAt(index) - '0';

            long newResult = result * 10 + digit;
            if (sign == 1 && newResult > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && -newResult < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            return helper(s, index + 1, newResult, sign);
        }

}
