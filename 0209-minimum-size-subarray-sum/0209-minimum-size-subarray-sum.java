class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE, n = nums.length;
        int i = 0, j = 0, sum = 0;
        while (j < n){
            sum += nums[j];
            while (sum >= target){
                min = Math.min(min, j-i+1);
                sum -= nums[i++];
            }
            j++;
        }
        return (min == Integer.MAX_VALUE)? 0: min;
    }
}