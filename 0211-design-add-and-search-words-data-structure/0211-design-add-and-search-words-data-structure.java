class WordDictionary {
    class TrieNode{
        TrieNode[] children;
        boolean endFlag;
        TrieNode(){
            children = new TrieNode[26];
            endFlag = false;
        }
    }
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for (char ch: word.toCharArray()){
            int idx = ch - 'a';
            if (curr.children[idx] == null)
                curr.children[idx] = new TrieNode();
            curr = curr.children[idx];
        }
        curr.endFlag = true;
    }
    public boolean searchHelper(String word, int start, TrieNode curr) {
        for (int i = start; i < word.length(); i++){
            char ch = word.charAt(i);
            if (ch == '.'){
                // if (i == word.length()-1)
                //     return true;
                for (int j = 0; j < 26; j++){
                    if (curr.children[j] != null && searchHelper(word, i+1, curr.children[j]))
                        return true;
                }
                return false;
            }
            else{
                int idx = ch - 'a';
                if (curr.children[idx] == null)
                    return false;
                curr = curr.children[idx];
            }
        }
        return curr.endFlag;
    }
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */