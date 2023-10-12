class Solution {
    void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0, j = 0;
        while (i < n && j < n){
            while (j < n && nums[j] != val) j++;
            while (i < n && nums[i] == val) i++;
            
            if (i < n && i > j){
                swap(i, j, nums);
                j++;
                i = j;
            }
            // i = j;
            i++;
        }
        return j;
    }
}