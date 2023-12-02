class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> l = new LinkedList<>();
        
        for (char c: p.toCharArray()){
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
                if (right - left == p.length())
                    l.add(left);
                // if (ans > right - left){
                //     l.add(left);
                // }
                left++;
            }
            
        }
        return l;
        // if (ans == s.length()+1)
        //     return "";
        // return s.substring(begin, begin+ans);
    }
}