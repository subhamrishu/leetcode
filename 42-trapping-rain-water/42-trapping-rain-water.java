class Solution {
    public int trap(int[] height) {
        int L = 0, R = height.length-1;
        int maxL = height[L], maxR = height[R];
        int res = 0;
        while (L < R){
            if (maxL <= maxR){
                res += maxL - height[L];
                L++;
            }
            else{
                res += maxR - height[R];
                R--;
            }
            maxL = Math.max(maxL, height[L]);
            maxR = Math.max(maxR, height[R]);
        }
        return res;
    }
}