class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0, max = nums[0];
        
        for (int i = 0; i < nums.length; i++){
            currSum += nums[i];
            max = currSum > max ? currSum : max;
            currSum = currSum < 0 ? 0 : currSum;
        }
        return max;
    }
}