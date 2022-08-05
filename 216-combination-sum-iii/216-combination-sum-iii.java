class Solution {
    List<List<Integer>> sol;
    void helper(int k, int target, int curr, List<Integer> temp){
        if (target < 0 || temp.size() > k)
            return;
        if (target == 0 && temp.size() == k){
            sol.add(new ArrayList(temp));
            return;
        }
        for (int i = curr; i <= 9; i++){
            temp.add(i);
            helper(k, target - i, i+1, temp);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        sol = new ArrayList();
        helper(k, n, 1, new ArrayList());
        return sol;
    }
}