class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || s.length() < t.length())
            return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int left = 0, start = 0, minLen = s.length();
        boolean flag = false;
        int count = t.length();
        
        for(int right = 0; right < s.length(); right++){
            if (map.containsKey(s.charAt(right))){
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if(map.get(s.charAt(right)) >= 0)
                    count--;
            }
            while (count == 0 && left <= right){
                flag = true;
                if(minLen > (right-left+1)){    
                    start = left;
                    minLen = right-left+1;
                }
                if(map.containsKey(s.charAt(left))){
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    if(map.get(s.charAt(left)) > 0)
                        count++;
                }
                left++;
            }
        }
        return flag == true ? s.substring(start, start+minLen) : "";
    }
}