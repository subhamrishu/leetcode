class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int maxLeft = height[left], maxRight = height[right];
        int totalArea = 0;
        while (left < right){
            if (height[left] < height[right]){
                if (maxLeft <= height[left]){
                    maxLeft = height[left];
                }
                else{
                    totalArea += maxLeft - height[left];
                }
                left++;
            }else{
                if(maxRight <= height[right]){
                    maxRight = height[right];
                }else{
                    totalArea += maxRight - height[right];
                }
                right--;
            }
        }
        return totalArea;
    }
}