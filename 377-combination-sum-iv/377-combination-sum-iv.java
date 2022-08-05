class Solution {
    Integer[] dp;
    int helper(int[] nums, int target){
        if (dp[target]!=null)
            return dp[target];
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if (target >= nums[i])
                res += helper(nums, target-nums[i]);
        }
        return dp[target] = res;
    }
    public int combinationSum4(int[] nums, int target) {
        dp = new Integer[target+1];
        dp[0] = 1;
        return helper(nums, target);
    }
}