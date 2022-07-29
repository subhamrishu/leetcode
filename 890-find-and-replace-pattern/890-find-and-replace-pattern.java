class Solution {
    boolean isPatternMatching(String pattern, String word){
        if (pattern.length() == 1)
            return true;
        Map<Character, Character> map1 = new HashMap();
        Map<Character, Character> map2 = new HashMap();
        char[] pc = pattern.toCharArray();
        char[] wc = word.toCharArray();
        map1.put(wc[0], pc[0]);
        map2.put(pc[0], wc[0]);
        for (int i = 1; i < pattern.length(); i++){
            map1.putIfAbsent(wc[i], pc[i]);
            map2.putIfAbsent(pc[i], wc[i]);
           
            if (map1.get(wc[i]) != pc[i] || map2.get(pc[i]) != wc[i])
                return false;
        }
        return true;
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList();
        for (String word: words){
            if(isPatternMatching(pattern, word))
                list.add(word);
        }
        return list;
    }
}