class Solution {
    int dp[];
    int helper(int[] cost, int curr){
        if (curr >= cost.length-1)
            return 0;
        if (dp[curr]!=-1)
            return dp[curr];
        return dp[curr] = Math.min(cost[curr] + helper(cost, curr+1), cost[curr+1] + helper(cost, curr+2));
    }
    public int minCostClimbingStairs(int[] cost) {
        // int sum = Math.min(cost[0], cost[1]);;
        // for(int i = 2;i < cost.length-1; i+=2){
        //     sum += Math.min(cost[i], cost[i+1]);
        // }
        // return sum;]
        dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return helper(cost, 0);
    }
}