class Solution {
    int[][] memo;
    int helper(int[] nums, int curr, int prev){
        if (curr == nums.length)
            return 0;
        else if (memo[curr][prev+1] != 0)
            return memo[curr][prev+1];
        int take = 0, dontTake = helper(nums, curr+1, prev);
        if (prev == -1 || nums[curr] > nums[prev]) 
            take = 1 + helper(nums, curr+1, curr);
        return memo[curr][prev+1] = Math.max(take, dontTake);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new int[n][n+1];
        return helper(nums, 0, -1);
    }
}