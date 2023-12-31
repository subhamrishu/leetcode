class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        
        int i = 0, j = nums.length-1, max = -1;
        while (i < j){
            int temp = nums[j] + nums[i];
            if (temp < k){
                max = Math.max(max, temp);
                i++;
            }else
                j--;
            
        }
        return max;
    }
}