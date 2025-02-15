package Arrays;

public class reverseArray {
    public void reverseArray(int arr[]) {
        // code here
        reverse(arr, 0, arr.length - 1);
    }
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
