class Solution {
    private int helper(int[] A, int K, int start, int[] dp) {
        int n = A.length;
        if (start >= n) return 0;
        if (dp[start] != 0) {
            return dp[start];
        }
        int maxSum = 0, maxEle = 0;
        for (int i = start; i < Math.min(n, start + K); i++) {
            maxEle = Math.max(maxEle, A[i]);
            maxSum = Math.max(maxSum, maxEle * (i - start + 1) + helper(A, K, i + 1, dp));
        }
        dp[start] = maxSum;
        return maxSum;
    }
    
    public int maxSumAfterPartitioning(int[] A, int K) {
        int n = A.length;
        int[] dp = new int[n];
        return helper(A, K, 0, dp);
    }
}