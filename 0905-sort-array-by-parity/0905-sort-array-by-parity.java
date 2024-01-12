class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int odd = n-1;
        for (int i = 0; i < odd; i++){
            if (nums[i] % 2 == 1){
                int temp = nums[i];
                nums[i] = nums[odd];
                nums[odd--] = temp;
                i--;
            }
        }
        return nums;
    }
}