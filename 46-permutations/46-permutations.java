class Solution {
    List<List<Integer>> sol;
    void backtrack(int[] nums, int currIndex, List<Integer> temp){
        if (temp.size() == nums.length){
            sol.add(new ArrayList(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if (!temp.contains(nums[i])){
                temp.add(nums[i]);
                backtrack(nums, i+1, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        sol = new ArrayList();
        backtrack(nums, 0, new ArrayList());
        return sol;
    }
}