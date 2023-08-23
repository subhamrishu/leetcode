class Solution {
    public int strStr(String haystack, String needle) {
        int hay_n = haystack.length(), n_n = needle.length();
        
        for (int i = 0; i < hay_n; i++){
            if (i + n_n > hay_n) break;
            for (int j = 0; j < n_n; j++){
                
                if (haystack.charAt(i+j) != needle.charAt(j)) break;
                if (j == n_n-1) return i;
            }
        }
        return -1;
    }
}