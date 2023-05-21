class Solution {
    static boolean checkAllZero(int[] freq){
        for (int i =0; i < 26; i++){
            if (freq[i] != 0)
                return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2)
            return false;
        for (char ch: s1.toCharArray()){
            freq1[ch-'a']++;
        }
        for (int i = 0; i < len1; i++){
            freq1[s2.charAt(i)-'a']--;
        }
        if(checkAllZero(freq1))
            return true;
        for (int i = len1; i < len2; i++){
            freq1[s2.charAt(i-len1)-'a']++;
            freq1[s2.charAt(i)-'a']--;
            if(checkAllZero(freq1))
                return true;
        }
        return false;
    }
}