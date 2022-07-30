class Solution {
    int[] maxFreq = new int[26];
    void toFreq(int[] arr, String word, boolean flag){
        
        for (char c: word.toCharArray()){
            arr[c-'a']++;
            if (flag)
                maxFreq[c-'a'] = Math.max(maxFreq[c-'a'], arr[c-'a']);
        }
    }
    boolean matchFreq(int[] words2freq, int[] freq){
        for(int i = 0; i <26; i++){
            if (freq[i] < words2freq[i])
                return false;
        }
        return true;
    }
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> sol = new ArrayList();
        for(String word: words2){
            int[] freq = new int[26];
            toFreq(freq, word, true);
        }
        for (String word: words1){
            int[] freq = new int[26];
            toFreq(freq, word, false);
            if(matchFreq(maxFreq, freq)){
                sol.add(word);
            }
        }
        return sol;
    }
}