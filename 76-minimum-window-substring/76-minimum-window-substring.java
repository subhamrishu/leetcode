class Solution {
    public String minWindow(String s, String t) {
        
        if (s.length() < t.length())
            return "";
        
        Map<Character, Integer> tFreq = new HashMap();
        
        for (char c : t.toCharArray()){
            tFreq.putIfAbsent(c, 0);
            tFreq.put(c, tFreq.get(c)+1);
        }
        
        char[] cs = s.toCharArray();
        int ns = cs.length, left = 0, start = 0;
        int have = 0, need = tFreq.size(), min = ns + 1;
        
        for (int right = 0; right < ns; right++){
            char c = cs[right];
            if (tFreq.containsKey(c)){
                tFreq.put(c, tFreq.get(c)-1);
                if (tFreq.get(c) == 0)
                    have++;
                
                while (have == tFreq.size()){
                    
                    if ((right - left + 1) < min){
                        min = right - left + 1;
                        start = left;
                    }
                    
                    char cl = cs[left++];
                    if (tFreq.containsKey(cl)){
                        if (tFreq.get(cl) == 0)
                            have--;
                        tFreq.put(cl, tFreq.get(cl)+1);
                    }
                }
            } 
        }
        return min > s.length() ? "" : s.substring(start, start + min);
    }
    
}