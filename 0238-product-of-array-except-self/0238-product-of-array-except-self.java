class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prod = new int[len];
        prod[0] = 1;
        for (int i = 1; i < len; i++){
            prod[i] = prod[i-1] * nums[i-1];
        }
        int prev = 1;
        for (int j = len-1; j >=0; j--){
            prod[j] *= prev;
            prev *= nums[j]; 
        }
        return prod;
    }
}