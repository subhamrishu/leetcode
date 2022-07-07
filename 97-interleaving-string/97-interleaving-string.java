class Solution {
    Boolean[][] memo;
    char[] c1, c2, c3;
    
//     boolean helper(String s1, String s2, String s3, String curr, int i, int j){
//         if (i > s1.length() || j >s2.length() || curr.length() > s3.length() || !s3.startsWith(curr)){
//             // System.out.println(i+" "+ j);
//             return false;
//         }
//         // System.out.println(curr+" ");
//         if (memo[i][j]!=0)
//             return memo[i][j]==1;
//         if (curr.equals(s3) && i == s1.length() && j == s2.length())
//             return true;
        
//         boolean left=false, right=false;
//         if (i < s1.length() && s1.charAt(i) == s3.charAt(i+j-1))
//             left =  helper(s1, s2, s3, curr+s1.charAt(i), i+1, j);
//         if (j < s2.length() && s2.charAt(j) == s3.charAt(i+j-1))
//             right =  helper(s1, s2, s3, curr+s2.charAt(j), i, j+1);
//         memo[i][j] = (left || right)? 1: -1;
//         return memo[i][j] == 1;
//     }
    boolean helper2(int i, int j){
        if (memo[i][j]!=null)
            return memo[i][j];
        
        boolean left=false, right=false;
        if (i > 0 && c1[i-1] == c3[i+j-1])
            left = helper2(i-1, j);
        if (j > 0 && c2[j-1] == c3[i+j-1])
            right = helper2(i, j-1);
        return memo[i][j] = left || right;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        // memo = new int[s1.length()+1][s2.length()+1];
        // return helper(s1, s2, s3, "", 0, 0);
        int l1 = s1.length();
        int l2 = s2.length();
        c1 = s1.toCharArray();
        c2 = s2.toCharArray();
        c3 = s3.toCharArray();
        if((l1 + l2) != s3.length())
            return false;
        
        memo = new Boolean[l1+1][l2+1];
        memo[0][0] = true;
         return helper2(l1, l2);
        // return memo[l1][l2];
    }
}