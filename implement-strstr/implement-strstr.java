class Solution {
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        if (haystack.equals(needle)) return 0;
        for (int i = 0; i < haystack.length() - n + 1; i++){
            if (haystack.charAt(i) == needle.charAt(0)){
                if (haystack.substring(i, i+n).equals(needle)) return i;
            }
        }
        return -1;
    }
}