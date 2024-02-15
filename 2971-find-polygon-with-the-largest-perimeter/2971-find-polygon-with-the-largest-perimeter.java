class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] + (long)nums[i];
        }
        long max = 0;
        for (int i = n-1; i >= 2; i--){
            if (prefix[i-1] > nums[i]){
                max = Math.max(max, prefix[i]);
            }
        }
        return max == 0 ? -1 : max;
    }
}