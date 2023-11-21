class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, ans = 0, right = 0; 
        long prod = 1;
        for (right = 0; right < nums.length; right++){
            prod *= nums[right];
            while (left <= right && prod >= k){
                prod /= nums[left++];
            }
            ans += right - left + 1;
            // System.out.println("left="+left+" right="+right+" ans= "+ans+"\n");
        }
        
        // ans += right - left - 2 > 0 ? right - left - 2: 0;
        // System.out.println("left="+left+" right="+right+" ans= "+ans+"\n");
        return ans;
    }
}