class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        int k = 0;
        char[] cs = s.toCharArray();
        for (char ch: cs){
            freq[ch-'a']++;
        }
        for (int i = 0; i < cs.length; i++){
            if (freq[cs[i]-'a'] == 1)
                return i;
        }
        return -1;
    }
}