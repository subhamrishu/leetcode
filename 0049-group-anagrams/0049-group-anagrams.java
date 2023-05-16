class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<Integer, List<String>> map = new HashMap<>();
        for(String str: strs){
            int[] freq = new int[26];
            for (char c : str.toCharArray()){
                freq[c-'a']++;
            }
            int key = Arrays.hashCode(freq);
            if (map.containsKey(key)){
                map.get(key).add(str);
            }
            else{
                map.put(key, new ArrayList<>());
                map.get(key).add(str);
            }
        }
        List<List<String>> sol = new ArrayList<>();
        for (int k: map.keySet()){
            sol.add(map.get(k));
        }
        return sol;
    }
}