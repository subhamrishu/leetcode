class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = arr[n+1] = 1;
        for (int i = 1; i <= n; i++){
            arr[i] = nums[i-1];
        }
        int[][] dp = new int[n+2][n+2];
        for (int length = 1; length <= n; length++){
            for (int left = 1; left <= n- length+1; left++){
                int right = left + length -1;
                for (int last = left; last<=right; last++){
                    dp[left][right] = Math.max(dp[left][right], 
                                              dp[left][last-1]+ 
                                              arr[left-1]*arr[last]*arr[right+1]+
                                              dp[last+1][right]);
                }
            }
        }
        return dp[1][n];
    }
}