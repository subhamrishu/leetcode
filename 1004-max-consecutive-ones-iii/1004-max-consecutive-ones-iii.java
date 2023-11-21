class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, ans = 0, zeroCnt = 0;
        for (int right = 0; right < nums.length; right++){
            if (nums[right] == 0){
                zeroCnt++;
            }
            while (zeroCnt > k){
                zeroCnt -= (nums[left++] == 0) ? 1 : 0;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}