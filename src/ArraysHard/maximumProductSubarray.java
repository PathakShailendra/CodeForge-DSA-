package ArraysHard;

public class maximumProductSubarray {
    public int maxProduct(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int pProduct = 1;
        int sProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            if (pProduct == 0) pProduct = 1;
            if (sProduct == 0) sProduct = 1;
            pProduct = pProduct * nums[i];
            sProduct = sProduct * nums[nums.length - i - 1];
            maxi = Math.max(maxi, Math.max(pProduct, sProduct));
        }
        return maxi;
    }
}
