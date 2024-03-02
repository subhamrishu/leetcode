class Solution {
    public int myAtoi(String s) {
        int res = 0;
        int sign = 1;
        int idx = 0;
        int n = s.length();
        char[] cs = s.toCharArray();
        
        while (idx < n && cs[idx] == ' '){
            idx++;
        }
        
        if (idx < n && cs[idx] == '-'){
            sign = -1;
            idx++;
        }else if (idx < n && cs[idx] == '+'){
            idx++;
        }
        
        while (idx < n && Character.isDigit(cs[idx])){
            int digit = cs[idx] - '0';
            
            if (res > Integer.MAX_VALUE/10 || 
                (res == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE % 10)){
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            
            res = 10 * res + digit;
            idx++;
        }
        return sign == -1 ? res * sign : res;
    }
}