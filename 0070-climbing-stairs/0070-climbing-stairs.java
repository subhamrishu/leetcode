class Solution {
    // int[] memo = new int[46];
    // public int climbStairsMemo(int n) {
    //     if (n <= 2)
    //         return n;
    //     if(memo[n] != 0)
    //         return memo[n];
    //     return memo[n] = climbStairs(n-1) + climbStairs(n-2);
    // }
//     public int climbStairsTopDown(int n) {
//         int[] dp = new int[n+1];
        
//         for(int i = 0; i <= n; i++){
//             if (i <= 2)
//                 dp[i] = i;
//             else
//                 dp[i] = dp[i-1] + dp[i-2];
//         }
//         return dp[n];
//     }
    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        int a = 1, b = 2, c= 0;
        for(int i = 3; i <=n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}