class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0, n = nums.length;
        for (int i = 0; i < n; i++){
            sum += nums[i];
        }
        int sum2 = (n * (n+1))/2;
        return sum2-sum;
    }
}