class Solution {
    int helper(int left, int right, int[] nums){
        if (left == right)
            return nums[left];
        int pickedLeft = nums[left] - helper(left+1, right, nums) ;
        int pickedRight = nums[right] - helper(left, right-1, nums) ;
        
        return Math.max(pickedLeft, pickedRight);
    }
    public boolean predictTheWinner(int[] nums) {
        return helper(0, (nums.length)-1, nums) >= 0;
    }
}