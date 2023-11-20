class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, zero = 0, ans = 0;
        for (int right = 0; right < nums.length; right++){
            if (nums[right] == 0){
                zero++;
            }
            while (zero > 1 && left <= right && nums[left++] != 0);
            
            if (zero > 1)
                zero--;
            
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}