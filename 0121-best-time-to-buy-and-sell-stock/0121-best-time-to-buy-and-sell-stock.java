class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 1)
            return 0;
        int i = 0, j = 1;
        int max = 0;
        while (i <= j && j < len){
            if (prices[j] - prices[i] > 0){
                max = Math.max(max, prices[j] - prices[i]);
                j++;
            }
            else{
                i = j;
                j++;
            }
        }
        return max;
    }
}