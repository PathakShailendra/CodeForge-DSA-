package math;

class Solution {
    static int evenlyDivides(int n) {
        // code here
        int count = 0;
        int org = n;
        while (n > 0) {
            int rem = n % 10;
            if(rem != 0 && org % rem == 0) {
                count++;
            }
            n /= 10;
        }
        return count;
    }
}