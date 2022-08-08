class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(row-1).size();
        int memo[] = new int[col];
        for (int i = 0; i<col; i++){
            memo[i] = triangle.get(row-1).get(i);
        }
        for (int i = row - 2; i >=0; i--){
            List<Integer> currRow = triangle.get(i);
            for (int j = 0; j < currRow.size(); j++){
                memo[j] = currRow.get(j) + ((memo[j] < memo[j+1]) ? memo[j] : memo[j+1]);
            }
        }
        
        return memo[0];
    }
}