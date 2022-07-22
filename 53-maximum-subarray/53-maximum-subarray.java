class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0], currSum = 0;
        for (int i = 0; i < nums.length; i++){
            currSum+=nums[i];
            max = Math.max(currSum, max);
            if (currSum < 0 ){
                currSum = 0;
                continue;
            }
            
        }
        return max;
    }
}