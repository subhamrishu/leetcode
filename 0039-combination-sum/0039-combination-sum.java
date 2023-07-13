class Solution {
    void dfs(int[] candidates, int target, int curr, List<Integer> temp, List<List<Integer>> sol){
        if (curr >= candidates.length || target < 0)
            return;
        else if (target == 0){
            sol.add(new ArrayList<>(temp));
            return;
        }
        for (int i = curr; i < candidates.length; i++){
            temp.add(candidates[i]);
            dfs(candidates, target-candidates[i], i, temp, sol);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> sol = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), sol);
        return sol;
    }
}