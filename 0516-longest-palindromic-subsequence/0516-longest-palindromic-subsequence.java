class Solution {
    int helper(char[] s, int i, int j, int[][] dp){
        if (i > j) return 0;
        else if (i == j) return 1;
        else if (dp[i][j] != 0) return dp[i][j];
        else if (s[i] == s[j])
            return dp[i][j] = 2 + helper(s, i+1, j-1, dp);
        else 
            return dp[i][j] = Math.max(helper(s, i+1, j, dp), helper(s, i, j-1, dp));
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        // for (int[] arr: dp){
        //     Arrays.fill(arr, -1);
        // }
        return helper(s.toCharArray(), 0, s.length()-1, dp);
    }
}