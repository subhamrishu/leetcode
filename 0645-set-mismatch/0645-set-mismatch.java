class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] count = new int[n+1];
        
        for (int i = 0; i < n; i++){
            count[nums[i]]++;
        }
        int k = 0;
        int[] sol = new int[2];
        for (int i = 1; i <= n; i++){
            if (count[i] == 2)
                sol[0] = i;
            else if (count[i] == 0)
                sol[1] = i;
        }
        return sol;
    }
}