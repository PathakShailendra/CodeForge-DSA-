package Arrays;

public class secondLargest {
    public int getSecondLargest(int[] arr) {
        // Code Here
        if (arr.length < 2) return -1; // Second largest possible nahi

        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
    }
}
