class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] canJump = new boolean[n];
        canJump[n-1] = true;
        for (int i = n-2; i>=0; i--){
            if (nums[i] != 0){
                int maxJump = i + nums[i];
                if (maxJump >= n-1){
                    canJump[i] = true;
                    continue;
                }
                while (maxJump > i){
                    if (canJump[maxJump] == true){
                        canJump[i] = true;
                        break;
                    }
                    maxJump--;
                }
            }
        }
        return canJump[0];
    }
}