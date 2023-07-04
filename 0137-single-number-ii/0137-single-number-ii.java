class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 1; i<=32; i++){
            int sum = 0;
            for (int num: nums){
                if (((num >> i) & 1) == 1){
                   sum++; 
                }
            }
            sum %= 3;
            if (sum != 0){
                ans |= sum << i;
            }
        }
        return ans;
    }
}