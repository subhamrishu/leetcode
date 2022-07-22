class Solution {
    int start = 0, end =0;
    void extendPalindrome(String s, int i, int j){
        int n = s.length();
        while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        if ((end-start) < (j - i)){
            start = i + 1;
            end = j;
        }
    }
    public String longestPalindrome(String s) {
        
        
        for(int i = 0; i < s.length(); i++){
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i+1);
        }
        String ans = "";
        for (int i = start; i <end; i++){
            ans+=s.charAt(i);
        }
        return ans;
    }
}