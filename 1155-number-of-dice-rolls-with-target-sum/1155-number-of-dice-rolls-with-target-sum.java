class Solution {
    int MOD = 1000000000 + 7;
    Integer[][] dp;
    int targetSum(int n, int k, int target){
        if (n == 0 && target == 0)
            return 1;
        else if (n == 0 || target <= 0)
            return 0;
        else if (dp[n][target] != null)
            return dp[n][target];
        int c = 0;
        for (int i = 1; i <= k; i++){
            c = (c + targetSum(n-1, k, target-i)) % MOD;
        }
        return dp[n][target]=c;
    }
    public int numRollsToTarget(int n, int k, int target) {
        dp = new Integer[n+1][target+1];
        return targetSum(n, k, target);
    }
}