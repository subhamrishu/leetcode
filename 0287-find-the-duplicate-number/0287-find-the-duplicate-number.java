class Solution {
    public int findDuplicate(int[] nums) {
        int sol = nums[0];
        for(int i = 0; i< nums.length; i++){
            if(nums[Math.abs(nums[i])-1] < 0){
                sol = Math.abs(nums[i]); 
                break;
            }
            else{
                nums[Math.abs(nums[i])-1] *= -1;
            }
        }
        for(int i = 0; i< nums.length; i++){
            if(nums[i] < 0){
                nums[i] *= -1;
            }
        }
        return sol;
    }
}