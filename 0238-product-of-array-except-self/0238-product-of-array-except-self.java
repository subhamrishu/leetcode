class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] lr = new int[len+1];
        int[] rl = new int[len+1];
        lr[0] = nums[0];
        for (int i = 1; i<len; i++){
            lr[i] = nums[i] * lr[i-1];
        }
        rl[len-1] = nums[len-1];
        for (int i = len-2; i >=0; i--){
            rl[i] = nums[i] * rl[i+1];
        }
        int[] prod = new int[len];
        for (int i = 0; i< len; i++){
            prod[i] = (i == 0) ? rl[i+1] : (i == len-1) ? lr[i-1] : lr[i-1] * rl[i+1];
        }
        return prod;
    }
}