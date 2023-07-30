class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        if (amount == 0 ) return 0;
        
        int n = coins.length;
        if (coins[0] > amount) return -1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int coin: coins){
            if (coin <= amount)
                dp[coin] = 1;
        }
        dp[0] = 0;
        for (int i = 1; i <= amount; i++){
            int min = Integer.MAX_VALUE;
            for (int coin: coins){
                int temp = (i - coin) < 0 ? Integer.MAX_VALUE: dp[i-coin];
                min = Math.min(min, temp);
            }
            dp[i] = (min == Integer.MAX_VALUE) ? min : min + 1;
        }
        // System.out.println(Arrays.toString(dp));
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}