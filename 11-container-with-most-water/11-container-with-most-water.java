class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n-1;
        int maxArea = Math.min(height[left], height[right]);
        while (left < right){
            int area = Math.min(height[left], height[right]) * (right - left);
            if (height[left] < height[right])
                left++;
            else
                right--;
            
            maxArea = Math.max(maxArea, area);
            // System.out.println(height[left]+" "+height[right]+" "+maxArea);
        }
        return maxArea;
    }
}