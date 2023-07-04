class Solution {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean endFlag;
        TrieNode(){
            for (int i = 0; i < 26; i++){
                children[i] = null;
            }
            endFlag = false;
        }
    }
    void insert(TrieNode root, String s){
        TrieNode curr = root;
        for (char ch: s.toCharArray()){
            if (curr.children[ch-'a'] == null){
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.endFlag = true;
    }
    boolean search(TrieNode root, String s){
        TrieNode curr = root;
        for (char ch: s.toCharArray()){
            if(curr.children[ch-'a'] == null)
                return false;
            curr = curr.children[ch-'a'];
        }
        return curr.endFlag;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        // Set<String> set = new HashSet<>();
        int len = s.length();
        TrieNode root = new TrieNode();
        for (String word: wordDict){
            // set.add(word);
            insert(root, word);
        }
        boolean[] dp = new boolean[len+1];
        dp[len] = true;
        for (int i = len-1; i >= 0; i--){
            for (int j = i+1; j <= len; j++){
                if (dp[j] && search(root, s.substring(i, j))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}