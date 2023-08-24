class Solution {
    public boolean isSubsequence(String s, String t) {
        int j = 0;
        for (int i = 0; i < s.length(); i++){
            while (j < t.length() && s.charAt(i) != t.charAt(j)){
                j++;
            }
            
            if (j == t.length() && i != s.length()) return false;
            // System.out.println(s.charAt(i)+" "+t.charAt(j)+" "+i+" "+j);
            j++;
        }
        return true;
    }
}