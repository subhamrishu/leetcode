class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        //0 denotes not bought yet- can buy
        //1 denotes bought can be sold now
        dp[0][0] = -prices[0]-fee;
        for (int i = 1; i < n; i++){
            for (int j = 0; j < 2; j++){
                if (j == 0) //buy stocks
                    dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i] - fee);
                else //sell stocks
                    dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
            }
        }
        return dp[n-1][1];
    }
}