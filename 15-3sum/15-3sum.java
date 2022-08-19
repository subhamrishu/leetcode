class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sol = new ArrayList();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++){
            if (i ==0 || (i >0 && nums[i]!=nums[i-1])){
                int target = -1 * nums[i], j = i+1, k = nums.length - 1;
                while (j < k){
                    if (nums[j] + nums[k] == target){
                        sol.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j+1]) j++;
                        while (j < k && nums[k] == nums[k-1]) k--;
                        j++;
                        k--;
                    }
                    else if (nums[j] + nums[k] < target)
                        j++;
                    else
                        k--;
                }
            }
        }
            
        return sol;
    }
    
}