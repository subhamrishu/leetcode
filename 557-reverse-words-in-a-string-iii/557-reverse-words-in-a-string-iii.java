class Solution {
    public void reverseString(char[] s, int start, int end) {
        while (start < end){
            char c = s[start];
            s[start++] = s[end];
            s[end--] = c;
        }
    }
    public String reverseWords(String s) {
        int start =0;
        char[] cs = s.toCharArray();
        for (int i = 0; i <= cs.length; i++){
            if (i == cs.length || cs[i] == ' '){
                reverseString(cs, start, i-1);
                start = i+1;
            }
        }
        return new String(cs);
    }
}