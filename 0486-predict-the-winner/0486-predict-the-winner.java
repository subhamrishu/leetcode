class Solution {
    Integer[][] dp;
    int helper(int left, int right, int[] nums){
        if (left == right)
            return nums[left];
        if (dp[left][right] != null)
            return dp[left][right];
        
        int pickedLeft = nums[left] - helper(left+1, right, nums) ;
        int pickedRight = nums[right] - helper(left, right-1, nums) ;
        
        return dp[left][right] = Math.max(pickedLeft, pickedRight);
    }
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        dp = new Integer[n][n];
        // return helper(0, n-1, nums) >= 0;
        for (int i = 0; i < n ; i++){
            dp[i][i] = nums[i];
        }
        
        for (int diff = 1; diff < n; diff++){
            for (int left = 0; left + diff < n; left++){
                int right = left + diff;
                dp[left][right] = Math.max(nums[left] - dp[left+1][right], nums[right] - dp[left][right-1]);
            }
        }
        return dp[0][n-1] >= 0;
    }
}