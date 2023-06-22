class Solution {
    public int maxProfit(int[] prices, int fee) {
         int n = prices.length;
        int old_sell = 0, old_buy = -prices[0]-fee;
        for (int i = 1; i < prices.length; i++){
            old_sell = Math.max(old_sell, old_buy + prices[i]);
            old_buy = Math.max(old_buy, old_sell - prices[i]-fee);
        }
        return old_sell;
    }
}