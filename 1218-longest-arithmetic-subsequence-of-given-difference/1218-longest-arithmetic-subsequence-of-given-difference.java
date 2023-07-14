class Solution {
    
    public int longestSubsequence(int[] nums, int diff) {
        Map<Integer, Integer> map  = new HashMap<>();
        int ans = 1;
        
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i] - diff)){
                map.put(nums[i], map.get(nums[i] - diff)+1);
            }else{
                map.put(nums[i], 1);
            }
            ans = Math.max(ans, map.get(nums[i]));
        }
        return ans;
    }
}