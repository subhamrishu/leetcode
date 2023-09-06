class Solution {
    // int[][] memo;
    // int helper1(char[] text1, char[] text2, int i, int j){
    //     if (i == text1.length || j == text2.length)
    //         return 0;
    //     if (memo[i][j] != -1)
    //         return memo[i][j];
    //     if (text1[i] == text2[j])
    //         return memo[i][j] = 1+ helper(text1, text2, i+1, j+1);
    //     else
    //         return memo[i][j] = Math.max(helper(text1, text2, i+1, j), helper(text1, text2, i, j+1));
    // }
    int helper2(char[] text1, char[] text2){
        int t1_n = text1.length, t2_n = text2.length; 
        int[][] dp = new int[t1_n+1][t2_n+1];
        for (int i = 0; i < t1_n; i++){
            dp[i][0] = 0;
        }
        for (int i = 0; i < t2_n; i++){
            dp[0][i] = 0;
        }
        for (int i = 1; i <=t1_n; i++){
            for (int j = 1; j <=t2_n; j++){
                if (text1[i-1] == text2[j-1])
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[t1_n][t2_n];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        // memo = new int[text1.length()+1][text2.length()+1];
        // for (int i = 0; i < text1.length(); i++){
        //     Arrays.fill(memo[i], -1);
        // }
        // return helper(text1.toCharArray(), text2.toCharArray(), 0, 0);
        return helper2(text1.toCharArray(), text2.toCharArray());
    }
}