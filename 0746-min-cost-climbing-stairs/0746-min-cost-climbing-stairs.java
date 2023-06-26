class Solution {
    int[] memo;
    // int minCost(int[] cost, int curr, int[] memo){
    //     if (curr >= cost.length) return 0;
    //     if (memo[curr] != 0)
    //         return memo[curr];
    //     return memo[curr] = cost[curr] + Math.min(minCost(cost, curr+1, memo), minCost(cost, curr+2, memo));
    // }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length-1;
        memo = new int[n+1];
        // return Math.min(minCost(cost, 0, memo), minCost(cost, 1, memo));
        for (int i = 0; i <= n; i++){
            if (i < 2)
                memo[i] = cost[i];
            else
                memo[i] = cost[i] + Math.min(memo[i-1], memo[i-2]);
        }
        return Math.min(memo[n-1], memo[n]);
    }
}