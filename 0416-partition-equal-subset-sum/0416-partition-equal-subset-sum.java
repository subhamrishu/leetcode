class Solution {
    int[][] memo;
    boolean helper(int[] nums, int curr, int sum){
        // System.out.println(curr+" "+sum);
        if (curr >= nums.length || sum < 0) return false;
        if (sum == 0)
            return true;
        if (memo[curr][sum] != 0) return memo[curr][sum] == 1;
        boolean take = helper(nums, curr+1, sum-nums[curr]);
        boolean dontTake = helper(nums, curr+1, sum);
        memo[curr][sum] = (take || dontTake) == true ? 1 : 2;
        return memo[curr][sum] == 1;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums)
            sum+= num;
        if (sum % 2 == 1) return false;
        int n = nums.length;
        memo = new int[201][sum+1];
        
        return helper(nums, 0, sum/2);
    }
}