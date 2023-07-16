class Solution {
    void helper(int[] candidates, int target, List<Integer> temp, List<List<Integer>> sol, int start){
        if (target == 0){
            sol.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++){
            if (i > start && candidates[i] == candidates[i-1]) continue;
            if (target - candidates[i] < 0) break;
            temp.add(candidates[i]);
            helper(candidates, target-candidates[i], temp, sol, i+1);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> sol = new ArrayList<>();
        helper(candidates, target, new ArrayList<>(), sol, 0);
        return sol;
    }
}