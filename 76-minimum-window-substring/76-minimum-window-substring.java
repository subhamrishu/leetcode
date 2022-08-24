class Solution {
    // boolean checkIfAllZero(Map<Character, Integer> map){
    //     // System.out.println(map);
    //     for (Integer value: map.values()){
    //         if (value > 0)
    //             return false;
    //     }
    //     return true;
    // }
    // public String minWindow(String s, String t) {
    //     if (s.length() < t.length())
    //         return "";
    //     char[] cs = s.toCharArray(), ct = t.toCharArray();
    //     Map<Character, Integer> map = new HashMap();
    //     for (int i = 0; i < ct.length; i++){
    //         map.putIfAbsent(ct[i], 0);
    //         map.put(ct[i], map.get(ct[i])+1);
    //     }
    //     // System.out.println(map);
    //     int ns = s.length();
    //     int  left = 0, right =0, min = cs.length+1,a=0,b=ns;
    //     while (right < ns && left <= right ){
    //         while(right < ns && !checkIfAllZero(map)){
    //             if (map.containsKey(cs[right]))
    //                 map.put(cs[right], map.get(cs[right])-1);
    //             right++;
    //         }
    //         // System.out.print(right+ " "+ map+ " ");
    //         while(left <=right && checkIfAllZero(map)){
    //             if (map.containsKey(cs[left]))
    //                 map.put(cs[left], map.get(cs[left])+1);
    //             left++;
    //         }
    //         // System.out.println(left);
    //         if(min > (right - left +1)){
    //             min = right - left +1;
    //             a = left;
    //             b = right;
    //         }
    //         // right++;
    //     }
    //     String sol = "";
    //     if (min == (ns+1))
    //         return sol;
    //     for (int i = a-1; i<b;i++){
    //         sol+=cs[i];
    //     }
    //     return sol;
    // }
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        Map<Character, Integer> tFreq = new HashMap();
        // Map<Character, Integer> window = new HashMap();

        for (char c : t.toCharArray()){
            tFreq.putIfAbsent(c, 0);
            tFreq.put(c, tFreq.get(c)+1);
        }
        
        char[] cs = s.toCharArray();
        int ns = cs.length, left = 0, start = 0;
        int have = 0, need = tFreq.size(), min = ns + 1;
        // int[] res = {0, ns};
        for (int right = 0; right < ns; right++){
            char c = cs[right];
            // window.putIfAbsent(c, 0);
            // window.put(c, window.get(c)+1);
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
            // if (tFreq.containsKey(c) && window.get(c) == tFreq.get(c))
            //     have++;
            
            // System.out.println(have + " "+need);
            // while (have == need){
            //     if ((right - left + 1) < min){
            //         min = right - left + 1;
            //         res[0] = left;
            //         res[1] = right;
            //     }
            //     // System.out.println(window + " " + cs[left]);
            //     window.put(cs[left], window.get(cs[left])-1);
            //     if (tFreq.containsKey(cs[left]) && tFreq.get(cs[left]) > window.get(cs[left]))
            //         have--;
            //     left++;
            // }
        }
        return min > s.length() ? "" : s.substring(start, start + min);
//         if (min == (ns+1))
//             return "";
        
//         String sol = "";
//         for (int i = res[0]; i <= res[1]; i++){
//             sol += cs[i];
//         }
//         return sol;
    }
    
}