class Solution {
    
    public void moveZeroes(int[] nums) {
        int i = -1, j = 0;
        while (j < nums.length){
            if (nums[j] != 0){
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            j++;
        }
        for (int k = i+1; k < nums.length; k++){
            nums[k] = 0;
        }
        
    }
}