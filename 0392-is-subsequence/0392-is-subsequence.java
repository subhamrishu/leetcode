class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            while (j < t.length() && t.charAt(j) != ch)
                j++;
            if (j == t.length())
                return false;
            j++;
        }
        return true;
    }
}