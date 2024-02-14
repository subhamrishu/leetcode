class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] sol = new int[n];
        int i =0, j = 0, k = 0;
        while (i < n && j < n){
            while (nums[i] < 0){
                i++;
            }
            while (nums[j] > 0){
                j++;
            }
            sol[k++] = nums[i++];
            sol[k++] = nums[j++];
        }
        return sol;
    }
}