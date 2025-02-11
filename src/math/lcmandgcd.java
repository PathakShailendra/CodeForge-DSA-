package math;

public class lcmandgcd {
    public static int[] lcmAndGcd(int a, int b) {
        // code here
        int[] res = new int[2];
        int oa = a;
        int ob = b;
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        res[1] = a;
        res[0] = (oa*ob)/a;
        return res;
    }
}
