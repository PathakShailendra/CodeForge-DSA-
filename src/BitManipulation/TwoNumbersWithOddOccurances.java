package BitManipulation;

public class TwoNumbersWithOddOccurances {
    public int[] twoOddNum(int arr[], int N) {
        // code here
        int xor = 0;

        // Step 1: XOR all elements
        for (int num : arr) {
            xor ^= num;
        }

        // Step 2: Find rightmost set bit
        int setBit = xor & -xor;

        int num1 = 0, num2 = 0;

        // Step 3: Divide numbers in two groups and XOR
        for (int num : arr) {
            if ((num & setBit) != 0) {
                num1 ^= num; // bit is set
            } else {
                num2 ^= num; // bit is not set
            }
        }

        // Step 4: Return in decreasing order
        return num1 > num2 ? new int[]{num1, num2} : new int[]{num2, num1};
    }
}
