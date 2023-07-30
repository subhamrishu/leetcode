class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n = coins.length;
        if (amount == 0 ) return 0;
        if (coins[0] > amount) return -1;
        
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++){
            dp[i] = Integer.MAX_VALUE;
            for (int coin: coins){
                if (i - coin < 0) break;
                if (dp[i-coin] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i-coin]+1, dp[i]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}