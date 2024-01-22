class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int dup = -1, missing = 1;
        
        for (int i = 0; i < n; i++){
            int idx = Math.abs(nums[i])-1;
            if (nums[idx] < 0)
                dup = nums[i];
            else
                nums[idx] *= -1; 
        }
        for (int i = 1; i < n; i++){
            if (nums[i] > 0)
                missing = i + 1;
        }
        return new int[]{Math.abs(dup), missing};
    }
}