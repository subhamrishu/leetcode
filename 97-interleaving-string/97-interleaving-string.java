class Solution {
    int[][] memo;
    
    boolean helper(String s1, String s2, String s3, String curr, int i, int j){
        if (i > s1.length() || j >s2.length() || curr.length() > s3.length() || !s3.startsWith(curr)){
            // System.out.println(i+" "+ j);
            return false;
        }
        // System.out.println(curr+" ");
        if (memo[i][j]!=0)
            return memo[i][j]==1;
        if (curr.equals(s3) && i == s1.length() && j == s2.length())
            return true;
        
        boolean left=false, right=false;
        if (i < s1.length())
            left =  helper(s1, s2, s3, curr+s1.charAt(i), i+1, j);
        if (j < s2.length())
            right =  helper(s1, s2, s3, curr+s2.charAt(j), i, j+1);
        memo[i][j] = (left || right)? 1: -1;
        return memo[i][j] == 1;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        memo = new int[s1.length()+1][s2.length()+1];
        return helper(s1, s2, s3, "", 0, 0);
        // StringBuilder rem = new StringBuilder(s3);
        // int ind = 0;
        // for (int i = 0;i <s1.length(); i++){
        //     ind = rem.indexOf(""+s1.charAt(i), ind);
        //     rem.deleteCharAt(ind);
        // }
        //  System.out.println(rem);
        // if (rem.toString().equals(s2))
        //     return true;
        // else 
        //     return false;
       
        // return true;
    }
}