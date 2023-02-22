class Solution {
    int[][] dp;
    int helper(String word1, String word2, int p1, int p2){
        if (p1 == word1.length())
            return word2.length() - p2;
        else if (p2 == word2.length())
            return word1.length() - p1;
        
        if (dp[p1][p2] != -1)
            return dp[p1][p2];
        int min = Integer.MAX_VALUE;
        //characters match, move both the pointers
        if (word1.charAt(p1) == word2.charAt(p2))
            dp[p1][p2] = helper(word1, word2, p1+1, p2+1);
        else{
            //insert
            min = Math.min(min, helper(word1, word2, p1, p2+1));
            //delete
            min = Math.min(min, helper(word1, word2, p1+1, p2));
            min = Math.min(min, helper(word1, word2, p1+1, p2+1));
            dp[p1][p2] = min + 1;
        }
        return dp[p1][p2];
        
    }
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()+1][word2.length()+1];
        for (int row[] : dp){
                Arrays.fill(row, -1);
            }
        return helper(word1, word2, 0, 0);
    }
}