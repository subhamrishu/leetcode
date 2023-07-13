class Solution {
    public void helper(List<List<Integer>> sol, List<Integer> temp, int curr, int[] nums){
        // if (curr >= nums.length){
        //     return;
        // }
        sol.add(new ArrayList<>(temp));
        for (int i = curr; i < nums.length; i++){
            temp.add(nums[i]);
            helper(sol, temp, i+1, nums);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        helper(sol, new ArrayList<>(), 0, nums);
        return sol;
    }
}