class Solution {
    public int jump(int[] nums) {
        int currEnd = 0, maxJumpPos = 0, sol = 0 ;
        for (int i = 0; i < nums.length-1; i++){
            maxJumpPos = Math.max(maxJumpPos, i + nums[i]);
            if (i == currEnd){
                currEnd = maxJumpPos;
                sol++;
            }
        }
        return sol;
    }
}