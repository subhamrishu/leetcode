class Solution {
    List<List<Integer>> sol;
    void helper(int[] candidates, int target, int sum, int curr, List<Integer> temp){
        if (sum > target || curr == candidates.length)
            return;
        if (sum == target){
            sol.add(new ArrayList(temp));
            return;
        }
        temp.add(candidates[curr]);
        helper(candidates, target, sum+candidates[curr], curr, temp);
        temp.remove(temp.size()-1);
        helper(candidates, target, sum, curr+1, temp);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        sol = new ArrayList();
        helper(candidates, target, 0, 0, new ArrayList());
        return sol;
    }
}