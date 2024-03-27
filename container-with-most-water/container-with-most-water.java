class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        
        int left = 0, right = height.length-1;
        while (left < right){
            int currArea = (right - left) * Math.min(height[right], height[left]);
            maxArea = Math.max(currArea, maxArea);
            if (height[right] < height[left]) right--;
            else left++;
        }
        return maxArea;
    }
}