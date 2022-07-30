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
        // List<int[]> ff = new ArrayList();
        // int[] words2freq = new int[26];
        for(String word: words2){
            int[] freq = new int[26];
            toFreq(freq, word, true);
            // ff.add(freq);
        }
        // int[] count = new int[words1.length];
        for (int i = 0; i<words1.length; i++){
            int[] freq = new int[26];
            toFreq(freq, words1[i], false);
            if(matchFreq(maxFreq, freq)){
                sol.add(words1[i]);
            }
            // for (int[] f: ff){
            //     if (matchFreq(f, freq))
            //         count[i]++;
            // }
            // if(count[i] == words2.length)
            //     sol.add(words1[i]);
        }
        // System.out.println(Arrays.toString(maxFreq));
        return sol;
    }
}