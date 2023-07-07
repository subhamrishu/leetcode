class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length, max = -1;
        int left = 0,  right = 0, zc = 0, oc = 0;
        for (right = 0; right < n; right++){
            if (nums[right] == 0)
                zc++;
            else
                oc++;
            while (zc > k){
                if (nums[left++] == 0)
                    zc--;
                else
                    oc--;
            }
            max = Math.max(max, right - left +1);
        }
        return max;
    }
}