class Solution {
    int[] buildLPS(String needle){
        int n = needle.length();
        int[] res = new int[n];
        Arrays.fill(res, -1);
        int i = 0, j =1;
        while (j < n){
            if (needle.charAt(i) == needle.charAt(j)){
                res[j++] = i++; 
            }
            else if (i > 0){
                i = res[i-1] + 1;
            }
            else
                j += 1;
        }
        return res;
    }
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length())
            return -1;
        int[] lps = buildLPS(needle);
        int m = haystack.length(), n = needle.length();
        int i = 0, j = 0;
        while (i < m){
            if (haystack.charAt(i) == needle.charAt(j)){
                if (j == n-1){
                    return i - n + 1;
                }
                i += 1;
                j += 1;
            }
            else if (j > 0)
                j = lps[j-1] + 1;
            else
                i += 1;
        }
        return -1;
    }
}