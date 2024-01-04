class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int count = 0, i = 0;
        while (i < nums.length){
            int temp = nums[i], j = i;
            while (j < nums.length && nums[j] == temp)
                j++;
            int c = j-i;
            if (c == 1)
                return -1;
            count += c/3;
            if (c%3 != 0)
                count++;
            i = j;
        }
        return count;
    }
}