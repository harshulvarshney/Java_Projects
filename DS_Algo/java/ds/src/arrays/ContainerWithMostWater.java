package arrays;

/**
 * https://leetcode.com/problems/container-with-most-water/
 *
 * Given n non-negative integers a1, a2, ..., an ,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
 * Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
 *
 * Notice that you may not slant the container.
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        if(height == null || height.length < 2)
            return 0;

        int n = height.length;
        int l = 0;
        int r = n-1;

        int max = Integer.MIN_VALUE;
        while(l < r) {
            int h = Math.min(height[l], height[r]);
            int cap = h*(r-1);
            max = Math.max(cap, max);

            if(height[l] < height[r])
                l++;
            else if(height[l] > height[r])
                r--;
            else {
                l++;
                r--;
            }
        }

        return max;
    }
}
