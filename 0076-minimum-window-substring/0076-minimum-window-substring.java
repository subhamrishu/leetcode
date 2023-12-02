class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int size = map.size();
        
        int left=0, right=0, ans = s.length()+1, begin = 0;
        
        while (right < s.length()){
            char ch = s.charAt(right);
            if (map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                if (map.get(ch) == 0)
                    size--;
            }
            right++;
            while (size == 0 && left <= right){
                char cl = s.charAt(left);
                if (map.containsKey(cl)){
                    map.put(cl, map.get(cl)+1);
                    if (map.get(cl) > 0)
                        size++;
                }
                if (ans > right - left){
                    ans = right - left;
                    begin = left;
                }
                left++;
            }
            
        }
        if (ans == s.length()+1)
            return "";
        return s.substring(begin, begin+ans);
    }
}