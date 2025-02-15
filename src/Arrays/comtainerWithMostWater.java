package Arrays;

public class comtainerWithMostWater {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int i = 0;
        int j = height.length-1;
        while(i < j){
            maxWater = Math.max(maxWater, (j-i)*Math.min(height[i], height[j]));
            if(height[i] < height[j])i++;
            else j--;
        }
        return maxWater;
    }
}
