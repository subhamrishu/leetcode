// class Solution {
//     int MOD = 1000000007;
//     Integer[][] dp;
//     int helper(int curr, int n, int previousGap){
//         if (curr > n) return 0;
//         if (curr == n) return previousGap == 0 ? 1 : 0;
//         if (dp[curr][previousGap] != null) return dp[curr][previousGap];
//         if (previousGap == 1)
//             return dp[curr][previousGap] = (helper(curr+1, n, 0) + helper(curr+1, n, 1)) % MOD;
//         return dp[curr][previousGap] = (helper(curr+1, n, 0) + helper(curr+2, n, 0) + (2*helper(curr+2, n, 1)))%MOD;
//     }
//     public int numTilings(int n) {
//         dp = new Integer[1001][2];
        
//         return helper(0, n, 0);
//     }
// }
class Solution {
    public int numTilings(int n) {
        int mod = 1000000007;
        int[] dp = new int[n];
        dp[0] = 1;
        if (n > 1) dp[1] = 2;
        if (n > 2) dp[2] = 5;
        for(int i = 3; i < n; i++) {
            dp[i] = (2 * dp[i - 1] % mod + dp[i - 3]) % mod;
        }
        return dp[n - 1];
    }
}