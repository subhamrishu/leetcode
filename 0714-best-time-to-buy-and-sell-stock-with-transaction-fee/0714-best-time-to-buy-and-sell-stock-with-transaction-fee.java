class Solution {
    public int maxProfit(int[] prices, int fee) {
         int n = prices.length;
        int[][] stocks = new int[n][2];
        //stocks[i][0] denotes sell, stocks[i][1] denotes buy 
        stocks[0][0] = 0; 
        stocks[0][1] = -prices[0]-fee;
        for (int i = 1; i < prices.length; i++){
            stocks[i][0] = Math.max(stocks[i-1][0], stocks[i-1][1] + prices[i]);
            stocks[i][1] = Math.max(stocks[i-1][1], stocks[i-1][0] - prices[i] - fee);
        }
        return stocks[n-1][0];
    }
}