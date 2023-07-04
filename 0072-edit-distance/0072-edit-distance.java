class Solution {
    int memo[][];
    int helper(int i, int j, String w1, String w2){
        if (i == w1.length() && j == w2.length())
            return 0;
        else if (i == w1.length())
            return w2.length() - j;
        else if (j == w2.length())
            return w1.length() - i;
        if (memo[i][j] != -1)
            return memo[i][j];
        else if (w1.charAt(i) == w2.charAt(j))
            return helper(i+1, j+1, w1, w2);
        int insert = helper(i, j+1, w1, w2);
        int delete = helper(i+1, j, w1, w2);
        int replace = helper(i+1, j+1, w1, w2);
        return memo[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        memo = new int[n][m];
        for (int[] arr: memo){
            Arrays.fill(arr, -1);
        }
        return helper(0, 0, word1, word2);
    }
}