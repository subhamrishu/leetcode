class Solution {
    void helper(int n, int k, List<Integer> temp, List<List<Integer>> sol, int start){
        if (k == 0){
            sol.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n-k+1; i++){
            temp.add(i);
            helper(n, k-1, temp, sol, i+1);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> sol = new ArrayList<>();
        helper(n, k, new ArrayList<>(), sol, 1);
        return sol;
    }
}