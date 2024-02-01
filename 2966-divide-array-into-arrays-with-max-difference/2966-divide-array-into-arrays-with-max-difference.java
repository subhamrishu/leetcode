class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int numOfArrays = nums.length/3;
        
        int[][] sol = new int[numOfArrays][3];
        // int k = 0;
        // sol[0][0] = nums[0];
        for (int i = 0; i < nums.length; i++){
                if (i%3 == 2 && ((nums[i]-nums[i-1]) > k || (nums[i] - nums[i-2]) > k || (nums[i-1] - nums[i-2]) > k)){
                    return new int[][]{};
                }
                // if (i%3 != 0 && (nums[i] - nums[i-1]) > k )
                    
                sol[i/3][i%3] = nums[i];
        }
        return sol;
    }
}