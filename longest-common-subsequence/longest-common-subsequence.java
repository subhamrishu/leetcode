class Solution {
    Integer[][] dp;
    int max = 0;
    int helper(char[] s1, char[] s2, int i, int j){
        // System.out.println("i = "+i+" j = "+j+" currLen = "+currLen);
        // max = Math.max(max, currLen);
        if (i == s1.length || j == s2.length){
            
            return 0;
        }
        
        if (dp[i][j] != null)
            return dp[i][j];
        
        // int a = 0;
        if (s1[i] == s2[j])
            return dp[i][j] = 1 + helper(s1, s2, i+1, j+1);
        
        return dp[i][j] = Math.max(helper(s1, s2, i+1, j), helper(s1, s2, i, j+1));
    }
    public int longestCommonSubsequence(String text1, String text2) {
//         dp = new Integer[text1.length()][text2.length()];
        
//         return helper(text1.toCharArray(), text2.toCharArray(), 0, 0);
        // return max;
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        
        int t1_n = t1.length, t2_n = t2.length; 
        int[][] dp = new int[t1_n+1][t2_n+1];
        for (int i = 0; i < t1_n; i++){
            dp[i][0] = 0;
        }
        for (int i = 0; i < t2_n; i++){
            dp[0][i] = 0;
        }
        for (int i = 1; i <=t1_n; i++){
            for (int j = 1; j <=t2_n; j++){
                if (t1[i-1] == t2[j-1])
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[t1_n][t2_n];
    }
}