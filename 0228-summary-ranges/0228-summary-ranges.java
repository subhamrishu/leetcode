class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> sol = new ArrayList<>();
        if (nums.length == 0)
            return sol;
        int prev = nums[0];
        if (nums.length == 1){
            sol.add(Integer.toString(prev));
            return sol;
        }
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[i-1]+1){
                if (prev == nums[i-1]){
                    sol.add(Integer.toString(prev));
                }
                else{
                    sol.add(prev+"->"+nums[i-1]);
                }
                prev = nums[i];
            }
            if (i == nums.length-1){
                if (prev == nums[i]){
                    sol.add(Integer.toString(prev));
                }
                else{
                    sol.add(prev+"->"+nums[i]);
                }
            }
        }
        return sol;
    }
}