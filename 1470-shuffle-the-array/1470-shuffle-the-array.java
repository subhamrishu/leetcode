class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] sol = new int[2*n];
        int j = 0;
        for (int i = 0; i < 2*n; i+=2){
            sol[i] = nums[j];
            sol[i+1] = nums[j+n];
            j++;
        }
        return sol;
    }
}