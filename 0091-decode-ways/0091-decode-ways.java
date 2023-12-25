class Solution {
    int helper(String s, int i, int[] memo){
        int n = s.length();
        if (i == n)
            return 1;
        if (s.charAt(i) == '0')
            return 0;
        if (memo[i] != -1){
            return memo[i];
        }
        int count = helper(s, i+1, memo);
        if (i < n-1 && ((s.charAt(i) - '0') * 10 + s.charAt(i+1) - '0') < 27)
            count += helper(s, i+2, memo);
        return memo[i] = count;
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return helper(s, 0, memo);
    }
}