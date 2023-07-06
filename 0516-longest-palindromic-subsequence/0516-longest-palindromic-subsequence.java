class Solution {
    // int helper(char[] s, int i, int j, int[][] dp){
    //     if (i > j) return 0;
    //     else if (i == j) return 1;
    //     else if (dp[i][j] != 0) return dp[i][j];
    //     else if (s[i] == s[j])
    //         return dp[i][j] = 2 + helper(s, i+1, j-1, dp);
    //     else 
    //         return dp[i][j] = Math.max(helper(s, i+1, j, dp), helper(s, i, j-1, dp));
    // }
    // public int longestPalindromeSubseq(String s) {
    //     int n = s.length();
    //     int[][] dp = new int[n][n];
    //     // for (int[] arr: dp){
    //     //     Arrays.fill(arr, -1);
    //     // }
    //     return helper(s.toCharArray(), 0, s.length()-1, dp);
    // }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++){
            dp[i][i] = 1;
        }
        char[] c = s.toCharArray();
        for (int i = n-1; i >= 0; i--){
            for (int j = i+1; j < n; j++){
                if (c[i] == c[j])
                    dp[i][j] = 2 + dp[i+1][j-1];
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }
}