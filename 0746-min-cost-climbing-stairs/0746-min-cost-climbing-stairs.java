class Solution {
    int minCost(int[] cost, int curr, int[] memo){
        if (curr >= cost.length) return 0;
        if (memo[curr] != 0)
            return memo[curr];
        return memo[curr] = cost[curr] + Math.min(minCost(cost, curr+1, memo), minCost(cost, curr+2, memo));
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n+1];
        return Math.min(minCost(cost, 0, memo), minCost(cost, 1, memo));
    }
}