class Solution {
    Integer[] dp;
    int helper(int n){
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;
        if (dp[n] != null)
            return dp[n];
        return dp[n] = helper(n-1) + helper(n-2);
    }
    public int climbStairs(int n) {
        dp = new Integer[n+1];
        return helper(n);
    }
}