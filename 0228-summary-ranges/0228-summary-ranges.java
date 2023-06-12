class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> sol = new ArrayList<>();
        int prev = 0;
        
        for (int i = 0; i < nums.length; i++){
            prev = nums[i];
            while(i < nums.length-1 && nums[i]+1 == nums[i+1]){
                i++;
            }
            if (prev != nums[i]){
                sol.add(prev+"->"+nums[i]);
            }else{
                sol.add(prev+"");
            }
        }
        return sol;
        // if (nums.length == 0)
        //     return sol;
        // int prev = nums[0];
        // if (nums.length == 1){
        //     sol.add(Integer.toString(prev));
        //     return sol;
        // }
        // for (int i = 1; i < nums.length; i++){
        //     if (nums[i] != nums[i-1]+1){
        //         if (prev == nums[i-1]){
        //             sol.add(Integer.toString(prev));
        //         }
        //         else{
        //             sol.add(prev+"->"+nums[i-1]);
        //         }
        //         prev = nums[i];
        //     }
        //     if (i == nums.length-1){
        //         if (prev == nums[i]){
        //             sol.add(Integer.toString(prev));
        //         }
        //         else{
        //             sol.add(prev+"->"+nums[i]);
        //         }
        //     }
        // }
        // return sol;
        
    }
}