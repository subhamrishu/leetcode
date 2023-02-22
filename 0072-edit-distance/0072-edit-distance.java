class Solution {
    int[][] dp;
    int helper(String word1, String word2, int p1, int p2){
        if (p1 == word1.length())
            return word2.length() - p2;
        else if (p2 == word2.length())
            return word1.length() - p1;
        if (dp[p1][p2] != -1)
            return dp[p1][p2];
        if (word1.charAt(p1) == word2.charAt(p2))
            return helper(word1, word2, p1+1, p2+1);
        int min = Integer.MAX_VALUE;
        //insert
        min = Math.min(min, helper(word1, word2, p1, p2+1));
        //delete
        min = Math.min(min, helper(word1, word2, p1+1, p2));
        min = Math.min(min, helper(word1, word2, p1+1, p2+1));
        
        return dp[p1][p2] = min + 1;
        
    }
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i < word1.length(); i++){
            for (int j = 0; j < word2.length(); j++){
                dp[i][j] = -1;
            }
        }
        return helper(word1, word2, 0, 0);
    }
}