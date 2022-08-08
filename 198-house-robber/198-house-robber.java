class Solution {
    Integer[] dp;
    int helper(int[] nums, int curr){
        if (curr >= nums.length)
            return 0;
        if (dp[curr]!=null)
            return dp[curr];
        return dp[curr] = Math.max(helper(nums, curr+2)+nums[curr], helper(nums, curr+1));
    }
    public int rob(int[] nums) {
        dp = new Integer[nums.length];
        return helper(nums, 0);
    }
}