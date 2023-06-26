class Solution {
    // int[] memo = new int[46];
    // public int climbStairsMemo(int n) {
    //     if (n <= 2)
    //         return n;
    //     if(memo[n] != 0)
    //         return memo[n];
    //     return memo[n] = climbStairs(n-1) + climbStairs(n-2);
    // }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        
        for(int i = 0; i <= n; i++){
            if (i <= 2)
                dp[i] = i;
            else
                dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}