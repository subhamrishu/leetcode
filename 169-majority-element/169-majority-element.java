class Solution {
    public int majorityElement(int[] nums) {
        int major = nums[0], vote = 1;
        
        for (int i = 1; i < nums.length; i++){
            if (vote == 0){
                major = nums[i];
                vote = 1;
            }
            else if(nums[i] == major){
                vote++;
            }
            else{
                vote--;
            }
        }
        return major;
    }
}