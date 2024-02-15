class Solution {
//     Integer[][] dp;
//     int bottomUp(int[] nums, int[] m, int curr, int left){
//         if (curr == m.length){
//             return 0;
//         }
//         if (dp[curr][left] != null)
//             return dp[curr][left];
//         int right = nums.length - 1 - (curr - left);
//         return dp[curr][left] = Math.max(bottomUp(nums, m, curr+1, left+1) + m[curr] * nums[left],
//                        bottomUp(nums, m, curr+1, left) + m[curr]* nums[right]);
        
//     }
    public int maximumScore(int[] nums, int[] multipliers) {
//         dp = new Integer[multipliers.length][nums.length];
        
//         return bottomUp(nums, multipliers, 0, 0);
        int m = multipliers.length;
        int n = nums.length;
        
        int[][] dp = new int[m+1][n+1];
        
        for (int i = m-1; i>=0; i--){
            for (int j = i; j >=0; j--){
                int right = n - 1 - (i - j);
                dp[i][j] = Math.max(dp[i+1][j+1] + multipliers[i]* nums[j],
                                   dp[i+1][j] + multipliers[i] * nums[right]);
            }
        }
        return dp[0][0];
    }
}