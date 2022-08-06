class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap();
        int i=0, j = 0, max = 0;
        
        for (char c: s.toCharArray()){
            if (map.containsKey(c)){
                i = Math.max(i, map.get(c)+1);
            }
            map.put(c, j);
            max = Math.max(max, j-i+1);
            j++;
        }
        return max;
    }
}
