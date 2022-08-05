class Solution {
    
    List<List<Integer>> sol;
    void helper(int[] candidates, int target, int curr, List<Integer> temp){
        if (target < 0 || curr > candidates.length)
            return;
        if (target == 0){
            sol.add(new ArrayList(temp));
            return;
        }
        for (int i = curr; i < candidates.length; i++){
            if(i == curr || candidates[i] != candidates[i-1]){
                temp.add(candidates[i]);
                helper(candidates, target - candidates[i], i+1, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        sol = new ArrayList();
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList());
        return sol;
    }
}