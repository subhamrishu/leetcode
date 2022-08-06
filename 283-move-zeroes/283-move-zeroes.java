class Solution {

    public void moveZeroes(int[] nums) {
        int zeroCount = 0, i = 0, j = 0;
        while (j < nums.length){
            if (nums[j] != 0){
                nums[i] = nums[j];
                i++;
            }
            else{
                zeroCount++;
            }
            j++;
        }
        while(zeroCount > 0){
            nums[i++] = 0;
            zeroCount--;
        } 
    }
}