class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> map = new HashMap();
        for (String word: strs){
            char arr[] = new char[26];
            for (int i=0; i<word.length();i++){
                arr[word.charAt(i)-'a']++;
            }
            String hashKey = new String(arr);
            map.putIfAbsent(hashKey, new ArrayList());
            map.get(hashKey).add(word);
        }
        // List<List<String>> op = new ArrayList<>();
        // map.forEach((k, v) -> op.add(v));
        // return op;
        return new ArrayList(map.values());
    }
}