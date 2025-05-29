package BitManipulation;

public class FindXorOfNumberFromLToR {
    public static int xorTill(int n) {
        int rem = n % 4;
        if (rem == 0) return n;
        else if (rem == 1) return 1;
        else if (rem == 2) return n + 1;
        else return 0;
    }

    public static int findXOR(int l, int r) {
        return xorTill(r) ^ xorTill(l - 1);
    }
}
