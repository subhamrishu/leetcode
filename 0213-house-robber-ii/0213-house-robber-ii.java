class Solution {
    int helper(int[] nums, int start, int end){
        if (start == end) return nums[start];
        int[] maxSum = new int[nums.length];
        maxSum[start] = nums[start];
        maxSum[start+1] = Math.max(nums[start], nums[start+1]);
        for (int i = start+2; i <= end; i++){
             maxSum[i] = Math.max(maxSum[i-1], nums[i] + maxSum[i-2]);
        }
        return maxSum[end];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(helper(nums, 0, n-2), helper(nums, 1, n-1));
    }
}