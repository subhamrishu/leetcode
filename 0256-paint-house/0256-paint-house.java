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
//         Integer[][] dp = new Integer[costs.length][4];
        
//         return paint(costs, 0, -1, dp);
        int[] dp = new int[3];
        int[] temp = new int[3];
        
        dp[0] = costs[0][0];
        dp[1] = costs[0][1];
        dp[2] = costs[0][2];
        
        temp[0] = dp[0];
        temp[1] = dp[1];
        temp[2] = dp[2];
        
        
        for (int i = 1; i < costs.length; i++){
            dp[0] = Math.min(temp[1], temp[2]) + costs[i][0];
            dp[1] = Math.min(temp[0], temp[2]) + costs[i][1];
            dp[2] = Math.min(temp[1], temp[0]) + costs[i][2];
            
            temp[0] = dp[0];
            temp[1] = dp[1];
            temp[2] = dp[2];
        }
        return Math.min(temp[0], Math.min(temp[1], temp[2]));
    }
}