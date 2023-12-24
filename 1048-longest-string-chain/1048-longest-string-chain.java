class Solution {
    int checkForPreviousChain(String word, Map<String, Integer> map){
        int n = word.length();
        int max = 1;
        for (int i = 0; i < n; i++){
            String temp = word.substring(0, i) + word.substring(i+1, n);
            if (map.containsKey(temp)){
                max = Math.max(max, map.get(temp)+1);
                // map.put(word, map.get(temp)+1);
                // return map.get(word);
            }
        }
        map.put(word, max);
        return max;
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparing(String::length));
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (String word: words){
            max = Math.max(max, checkForPreviousChain(word, map));
        }
        return max;
    }
}