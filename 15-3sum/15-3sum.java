class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> sol = new HashSet();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            int j = i+ 1;
            int k = nums.length - 1;
            while (j < k){
                int target = nums[i] + nums[j] + nums[k];
                if (target == 0) 
                    sol.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                else if (target > 0)
                    k--;
                else
                    j++;
            }
        }
        return new ArrayList(sol);
    }
    
}