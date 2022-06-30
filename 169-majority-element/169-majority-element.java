class Solution {
    public int majorityElement(int[] nums) {
        int candidate = -1, vote = 0;
        
        for (int i=0; i<nums.length; i++){
            if (vote == 0){
                candidate = nums[i];
                vote += 1;
            }
            else if (candidate == nums[i]){
                vote += 1;
            }
            else{
                vote -= 1;
            }
            
        }
        return candidate;
    }
}