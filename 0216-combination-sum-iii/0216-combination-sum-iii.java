class Solution {
    void helper(int n, int k, int curr, List<Integer> temp, List<List<Integer>> sol){
       
        if (n == 0 && temp.size() == k){
            sol.add(new ArrayList<>(temp));
            return;
        }
         else if (curr > 9 || n < 0 || temp.size() > k || (n == 0 && temp.size() != k)){
            return;
        }
        for (int i = curr; i <= 9; i++){
            temp.add(i);
            helper(n-i, k, i+1, temp, sol);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> sol = new ArrayList<>();
        
        helper(n, k, 1, new ArrayList<>(), sol);
        return sol;
    }
}