public class containerWithMostWater {
    // two pointers
    // use two pointers to keep track of water area
    // the height of the area would be determined as lower height
    // the length between the left and right would be determined
    public int maxArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int maxArea = 0, l = 0, r = height.length - 1;

        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }
}
