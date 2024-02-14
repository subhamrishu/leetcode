class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] sol = new int[n];
        int pos =0, neg = 1, k = 0;
        for (int i = 0; i < n; i++){
            if (nums[i] > 0){
                sol[pos] = nums[i];
                pos+=2;
            }else{
                sol[neg] = nums[i];
                neg+=2;
            }
        }
        return sol;
    }
}