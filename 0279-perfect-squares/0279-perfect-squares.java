class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        int max_squares_num = (int)Math.sqrt(n)+1;
        int[] squares = new int[max_squares_num];
        
        for (int i = 1; i < max_squares_num; i++){
            squares[i] = i * i;
        }
        
        for (int i = 1; i <= n; i++){
            for (int j = 1; j < max_squares_num; j++){
                if (i < squares[j])
                    break;
                dp[i] = Math.min(dp[i], dp[i-squares[j]] + 1);
            }
        }
        return dp[n];
    }
}