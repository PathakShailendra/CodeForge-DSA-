package Arrays;

public class trappingRainWater {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int lmax = Integer.MIN_VALUE;
        int rmax = Integer.MIN_VALUE;
        int total = 0;
        while(left < right){
            lmax = Math.max(lmax, height[left]);
            rmax = Math.max(rmax, height[right]);
            total += lmax < rmax ? lmax - height[left++] : rmax - height[right--];
        }
        return total;
    }
}
