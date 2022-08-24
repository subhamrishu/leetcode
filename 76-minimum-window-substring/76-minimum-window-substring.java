class Solution {
    boolean checkIfAllZero(Map<Character, Integer> map){
        // System.out.println(map);
        for (Integer value: map.values()){
            if (value > 0)
                return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        char[] cs = s.toCharArray(), ct = t.toCharArray();
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < ct.length; i++){
            map.putIfAbsent(ct[i], 0);
            map.put(ct[i], map.get(ct[i])+1);
        }
        // System.out.println(map);
        int ns = s.length();
        int  left = 0, right =0, min = cs.length+1,a=0,b=ns;
        while (right < ns && left <= right ){
            while(right < ns && !checkIfAllZero(map)){
                if (map.containsKey(cs[right]))
                    map.put(cs[right], map.get(cs[right])-1);
                right++;
            }
            // System.out.print(right+ " "+ map+ " ");
            while(left <=right && checkIfAllZero(map)){
                if (map.containsKey(cs[left]))
                    map.put(cs[left], map.get(cs[left])+1);
                left++;
            }
            // System.out.println(left);
            if(min > (right - left +1)){
                min = right - left +1;
                a = left;
                b = right;
            }
            // right++;
        }
        String sol = "";
        if (min == (ns+1))
            return sol;
        for (int i = a-1; i<b;i++){
            sol+=cs[i];
        }
        return sol;
    }
}