class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;
        
        int[] count = new int[26];
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        for (int i = 0; i < len1; i++) {
            count[str1[i] - 'a']++;
            count[str2[i] - 'a']--;
        }
        if (allZero(count)) return true;
        
        for (int i = len1; i < len2; i++) {
            count[str2[i]- 'a']--;
            count[str2[i-len1] - 'a']++;
            if (allZero(count)) return true;
        }
        
        return false;
    }
    
    boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}
