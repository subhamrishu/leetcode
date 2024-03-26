class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i=0; i<strs.length; i++) {
            char[] count = new char[26];
            for (char ch: strs[i].toCharArray()) {
                count[ch - 'a']++;
            }
            String str = new String(count);
            // System.out.println(str);
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}