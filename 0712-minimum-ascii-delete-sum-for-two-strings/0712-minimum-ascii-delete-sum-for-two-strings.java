class Solution {
    int[][] memo;
    int getASCII(int start, String s){
        int sum = 0;
        for (int i = start; i < s.length(); i++){
            sum += s.charAt(i);
        }
        return sum;
    }
    int helper(String s1, String s2, int i, int j){
        if (i > s1.length()-1)
            return getASCII(j, s2);
        else if (j > s2.length()-1)
            return getASCII(i, s1);
        else if (memo[i][j] != -1)
            return memo[i][j];
        else if (s1.charAt(i) == s2.charAt(j))
            return memo[i][j] = helper(s1, s2, i+1, j+1);
        return memo[i][j] = Math.min(s1.charAt(i) + helper(s1, s2, i+1, j), s2.charAt(j) + helper(s1, s2, i, j+1));
    }
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        memo = new int[n][m];
        for (int[] arr: memo)
            Arrays.fill(arr, -1);
        return helper(s1, s2, 0, 0);
    }
}