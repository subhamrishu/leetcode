class Solution {
    public int minOperations(int[] nums) {
        int N = nums.length;
        Arrays.sort(nums);
        int ans = N, unique = 1, j = 0;
        for (int i = 1; i < N; i++){
            if (nums[i] != nums[i-1]){
                nums[unique++] = nums[i];
            }
        }
        for (int i = 0; i < unique; i++){
            while (j < unique && nums[j] - nums[i] <= N -1)
                j++;
            ans = Math.min(ans, N-(j-i));
        }
        return ans;
    }
}