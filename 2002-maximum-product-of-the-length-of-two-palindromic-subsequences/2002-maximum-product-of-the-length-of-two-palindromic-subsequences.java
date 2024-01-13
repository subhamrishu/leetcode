class Solution {
    boolean isPalindrome(String s){
        char[] cs = s.toCharArray();
        int i = 0, j = cs.length-1;
        while (i < j){
            if (cs[i] != cs[j])
                return false;
            i++;
            j--;
        }
        return true;
    }
    int dfs(String s, String s1, String s2, int curr){
        if (curr == s.length()){
            if (isPalindrome(s1) && isPalindrome(s2)){
                return s1.length() * s2.length();
            }
            else 
                return 0;
        }
            
            int a = dfs(s, s1+s.charAt(curr), s2, curr+1);
            int b = dfs(s, s1, s2+s.charAt(curr), curr+1);
            int c = dfs(s, s1, s2, curr+1);
            return Math.max(a, Math.max(b,c));
        
    }
    public int maxProduct(String s) {
        return dfs(s, "", "", 0);
    }
}