class Solution {
    Boolean[][] memo;
    boolean helper(int[] nums, int curr, int sum){
        // System.out.println(curr+" "+sum);
        if (curr >= nums.length || sum < 0) return false;
        if (sum == 0)
            return true;
        if (memo[curr][sum] != null) return memo[curr][sum];
        boolean take = helper(nums, curr+1, sum-nums[curr]);
        boolean dontTake = helper(nums, curr+1, sum);
        return memo[curr][sum] = (take || dontTake);
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums)
            sum+= num;
        if (sum % 2 == 1) return false;
        int n = nums.length;
        memo = new Boolean[n+1][sum+1];
        
        return helper(nums, 0, sum/2);
    }
}