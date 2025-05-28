package BitManipulation;

public class GetBit {
    static boolean checkKthBit(int n, int k) {
        // Your code here
        return ((n & (1 << k)) != 0);
    }
}
