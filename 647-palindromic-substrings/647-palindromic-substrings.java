class Solution {
    int extendPalindrome(String s, int left, int right){
        char[] ch = s.toCharArray();
        int count = 0;
        while (left >= 0 && right < s.length() && ch[left--] == ch[right++])
            count++;
        return count;
    }
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            count += extendPalindrome(s, i, i);
            count += extendPalindrome(s, i, i+1);
        }
        return count;
    
    }
}