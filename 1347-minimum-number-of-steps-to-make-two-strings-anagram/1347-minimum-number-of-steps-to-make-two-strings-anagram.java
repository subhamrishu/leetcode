class Solution {
    public int minSteps(String s, String t) {
        int[] freq = new int[26];
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        for(int i = 0; i < s.length(); i++){
            freq[cs[i]-'a']++;
            freq[ct[i]-'a']--;
        }
        int sol = 0;
        for (int i = 0; i < 26; i++){
            if (freq[i] > 0)
            sol += freq[i];
        }
        return sol;
    }
}