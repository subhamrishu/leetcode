class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] sol = new int[n];
        sol[0] = 1;
        for (int i = 1; i < n; i++){
            sol[i] = nums[i-1] * sol[i-1];
        }
        int reverseProd = 1;
        for (int i = n-1; i >= 0; i--){
            sol[i] *= reverseProd;
            reverseProd *= nums[i];
        }
        return sol;
    }
}