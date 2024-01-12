class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int[] aux = new int[n];
        int e = 0, o = n-1;
        for (int i = 0; i < n; i++){
            if (nums[i] % 2 == 0){
                aux[e++] = nums[i];
            }else{
                aux[o--] = nums[i];
            }
        }
        return aux;
    }
}