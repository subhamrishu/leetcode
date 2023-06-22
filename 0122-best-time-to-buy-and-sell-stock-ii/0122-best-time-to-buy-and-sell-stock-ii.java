class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit =0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] - prices[i-1] > 0)
                profit += (prices[i] - prices[i-1]);
        }
        return profit;
    }
}