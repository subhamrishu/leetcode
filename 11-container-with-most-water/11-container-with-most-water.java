class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n-1;
        int maxArea = (n-1)*Math.min(height[left], height[right]);
        boolean flag = true;
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