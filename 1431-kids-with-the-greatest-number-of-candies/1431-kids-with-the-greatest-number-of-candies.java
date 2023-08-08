class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int i = 0; i < candies.length; i++){
            max = Math.max(max, candies[i]);
        }
        List<Boolean> sol = new ArrayList<>();
        for (int candy: candies){
            sol.add((candy+extraCandies) >= max);
        }
        return sol;
    }
}