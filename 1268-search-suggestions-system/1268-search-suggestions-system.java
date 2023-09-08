class Solution {
    int count = 0;
    class TrieNode{
        TrieNode[] children;
        boolean endFlag;
        String word;
        TrieNode(){
            children = new TrieNode[26];
            endFlag = false;
            word = "";
        }
    }
    class Trie{
        TrieNode root;
        Trie(){
            root = new TrieNode();
        }
        void addWord(String word){
            TrieNode curr = root;
            for (char ch: word.toCharArray()){
                int idx = ch - 'a';
                if(curr.children[idx] == null)
                    curr.children[idx] = new TrieNode();
                curr = curr.children[idx];
            }
            curr.endFlag = true;
            curr.word = word;
        }
        void suggest(TrieNode curr, List<String> sol){
            
            if (curr.endFlag){
                sol.add(curr.word);
                count++;
            }
            for (int j = 0; j < 26 && count < 3; j++ ){
                if (curr.children[j] != null)
                    suggest(curr.children[j], sol);
            } 
            
        }
        List<String> search(String prefix){
            List<String> sol = new ArrayList<>();
            TrieNode curr = root;
            for (char ch: prefix.toCharArray()){
                if (curr.children[ch-'a'] == null)
                    return sol;
                curr = curr.children[ch-'a'];
            }
            
            suggest(curr, sol);
            return sol;
            
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> sol = new ArrayList<>();
        Trie trie = new Trie();
        for (String product: products){
            trie.addWord(product);
        }
        StringBuilder sb = new StringBuilder();
        for (char ch: searchWord.toCharArray()){
            count = 0;
            sol.add(trie.search(sb.append(ch).toString()));
        }
        return sol;
    }
}