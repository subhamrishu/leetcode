class Solution {
    int paint(int[][] costs, int curr, int last, Integer[][] dp){
        if (curr == costs.length)
            return 0;
        if (last != -1 && dp[curr][last+1] != null)
            return dp[curr][last+1];
        // System.out.println(curr+" "+last);
        int sum1 = (0 == last) ? Integer.MAX_VALUE : costs[curr][0] + paint(costs, curr+1, 0, dp);
        int sum2 = (1 == last) ? Integer.MAX_VALUE : costs[curr][1] + paint(costs, curr+1, 1, dp);
        int sum3 = (2 == last) ? Integer.MAX_VALUE : costs[curr][2] + paint(costs, curr+1, 2, dp);
        
        return dp[curr][last+1] = Math.min(sum1, Math.min(sum2, sum3));
    }
    public int minCost(int[][] costs) {
        Integer[][] dp = new Integer[costs.length][4];
        
        return paint(costs, 0, -1, dp);
    }
}