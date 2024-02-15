class Solution {
    Integer[][] dp;
    int bottomUp(int[] nums, int[] m, int curr, int left){
        if (curr == m.length){
            return 0;
        }
        if (dp[curr][left] != null)
            return dp[curr][left];
        int right = nums.length - 1 - (curr - left);
        return dp[curr][left] = Math.max(bottomUp(nums, m, curr+1, left+1) + m[curr] * nums[left],
                       bottomUp(nums, m, curr+1, left) + m[curr]* nums[right]);
        
    }
    public int maximumScore(int[] nums, int[] multipliers) {
        dp = new Integer[multipliers.length][nums.length];
        
        return bottomUp(nums, multipliers, 0, 0);
    }
}