class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap();
        int max=0, start = 0, n = s.length();
        char[] c = s.toCharArray();
        for (int i = 0; i < n; i++){
            if(map.containsKey(c[i])){
                start = Math.max(start, map.get(c[i])+1);
            }
            map.put(c[i], i);
            max = Math.max(max, i - start+1);
            // System.out.println("max = "+max +" i = "+i +" start = "+start);
        }
        // max = Math.max(max, n - start-1);
        return max;
    }
}