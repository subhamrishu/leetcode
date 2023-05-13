class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        int s_len = s.length();
        int t_len = t.length();
        
        if (s_len != t_len)
            return false;
        
        for (int i = 0; i < s_len; i++){
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        }
        
        for (int i = 0; i<26; i++){
            if (freq[i] != 0)
                return false;
        }
        return true;
    }
}