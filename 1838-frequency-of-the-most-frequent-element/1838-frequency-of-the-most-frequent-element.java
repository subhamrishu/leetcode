class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1, j = 0, sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            while (j <= i && (i-j+1)*nums[i] - sum > k){
                sum -= nums[j];
                j++;
            }
            ans = Math.max(ans, (i-j+1));
        }
        return ans;
    }
}