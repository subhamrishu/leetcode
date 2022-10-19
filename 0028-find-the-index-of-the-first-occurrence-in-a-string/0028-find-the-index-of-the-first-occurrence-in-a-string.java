class Solution {
    public int strStr(String haystack, String needle) {
        int ln = needle.length(), lh = haystack.length();
        int n = 0, h = 0;
        while (n < ln && h < lh){
            while (h < lh && n < ln && haystack.charAt(h) == needle.charAt(n)){
                h++; n++;
            }
            if (n == ln)
                return h - n;
            h = (n == 0) ? h+1 : h-n+1;
            n = 0;
            
        }
        return -1;
    }
}