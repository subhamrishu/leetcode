class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        int len = s.length();
        for (String word: wordDict){
            set.add(word);
        }
        boolean[] dp = new boolean[len+1];
        dp[len] = true;
        for (int i = len-1; i >= 0; i--){
            for (int j = i+1; j <= len; j++){
                if (dp[j] && set.contains(s.substring(i, j))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}