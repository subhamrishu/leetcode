class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefix = 1;
        int[] res = new int[nums.length];
        for (int i = 0; i<nums.length; i++){
            res[i] = prefix;
            prefix *= nums[i];
        }
        int postfix = 1;
        for(int i = nums.length-1; i>=0; i--){
            res[i] *= postfix;
            postfix *= nums[i];
        }
        return res;
    }
}