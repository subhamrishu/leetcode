class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> map = new HashMap();
        for (String word: strs){
            int arr[] = new int[26];
            for (int i=0; i<word.length();i++){
                arr[word.charAt(i)-'a']++;
            }
            String hash = "";
            for (int i = 0; i<26; i++){
                if(arr[i] != 0){
                    hash+=(char)(i+'a')+Integer.toString(arr[i]);
                    
                }
            }
            // System.out.println(hash);
            map.putIfAbsent(hash, new ArrayList());
            map.get(hash).add(word);
        }
        List<List<String>> op = new ArrayList<>();
        map.forEach((k, v) -> op.add(v));
        return op;
        // return new ArrayList(map.values());
    }
}