class Solution {
    int countPalindrome(char[] s, int i, int j){
        int count = 0;
        while (i >=0 && j < s.length && s[i] == s[j]){
            count++;
            i--;
            j++;
        }
        return count;
    }
    public int countSubstrings(String s) {
        int sol = 0;
        char[] cs = s.toCharArray();
        
        for (int i = 0; i < cs.length; i++){
            sol += countPalindrome(cs, i, i);
            sol += countPalindrome(cs, i, i+1);
        }
        return sol;
    }
}