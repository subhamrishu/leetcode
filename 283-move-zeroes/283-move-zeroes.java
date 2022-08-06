class Solution {
    void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void moveZeroes(int[] nums) {
        int zeroCount = 0, i = 0, j = 0;
        while (j < nums.length){
            if (nums[j] != 0){
                swap(nums, i, j);
                i++;
            }
            else{
                zeroCount++;
            }
            j++;
        }
        // System.out.println(Arrays.toString(nums));
        
        while(zeroCount > 0){
            nums[i++] = 0;
            zeroCount--;
        }
        // System.out.println(Arrays.toString(nums));
    }
}