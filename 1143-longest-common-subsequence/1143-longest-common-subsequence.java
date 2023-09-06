class Solution {
    int[][] memo;
    int helper(char[] text1, char[] text2, int i, int j){
        if (i == text1.length || j == text2.length)
            return 0;
        if (memo[i][j] != -1)
            return memo[i][j];
        if (text1[i] == text2[j])
            return memo[i][j] = 1+ helper(text1, text2, i+1, j+1);
        else
            return memo[i][j] = Math.max(helper(text1, text2, i+1, j), helper(text1, text2, i, j+1));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()+1][text2.length()+1];
        for (int i = 0; i < text1.length(); i++){
            Arrays.fill(memo[i], -1);
        }
        return helper(text1.toCharArray(), text2.toCharArray(), 0, 0);
    }
}