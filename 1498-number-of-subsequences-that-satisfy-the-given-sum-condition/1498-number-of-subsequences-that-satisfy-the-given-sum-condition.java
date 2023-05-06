class Solution {
    int mod = (int)1e9 + 7;
//     int pow(int a, int x){
//         int res = 1;
//         while (x > 0){
//             if (x % 2 == 1){
//                 res = (res * a) % mod;
//                 x--;
//             }
//             else{
//                 a = (a*a);
//                 x /= 2;
//             }
//         }
//         return res;
        
//     }
    public int numSubseq(int[] nums, int target) {
        int i = 0, j = nums.length-1, res = 0;
        Arrays.sort(nums);
        // System.out.println(mod);
        int[] pow = new int[j+1];
        pow[0] = 1;
        for (int k = 1; k<=j; k++){
            pow[k] = (pow[k-1] * 2)%mod;
        }
        while (i <= j){
            if (nums[i] + nums[j] > target)
                j--;
            else{
                res = (res + pow[j-i])%mod;
                i++;
            }
        }
        return res;
    }
}