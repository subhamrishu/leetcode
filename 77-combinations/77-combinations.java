class Solution {
    List<List<Integer>> sol;
    void generateCombinations(int n, int k, int curr, List<Integer> temp){
        if (temp.size() == k){
            sol.add(new ArrayList(temp));
            return;
        }
        
        for(int i = curr; i <=n; i++){
            temp.add(i);
            generateCombinations(n, k, i+1, temp);
            temp.remove(temp.size()-1);
        }
        
    }
    public List<List<Integer>> combine(int n, int k) {
        sol = new ArrayList();
        generateCombinations(n, k, 1, new ArrayList());
        return sol;
    }
}