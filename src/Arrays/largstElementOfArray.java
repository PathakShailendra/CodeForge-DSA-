package Arrays;

public class largstElementOfArray {
    public static int largest(int[] arr) {
        int max = arr[0];
        for(int num : arr) {
            if(num > max){
                max = num;
            }
        }
        return max;
    }
}
