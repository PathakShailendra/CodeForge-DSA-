package BitManipulation;

public class CountBits {
    public int count(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;  // right shift
        }
        return count;
    }
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i = 1; i <  n+1; i++){
            res[i] = count(i);
        }
        return res;
    }
}
