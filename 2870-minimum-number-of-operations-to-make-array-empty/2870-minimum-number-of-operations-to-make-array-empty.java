class Solution {
    public int minOperations(int[] nums) {
        int count  = 0, max = 0;
        int[] freq = new int[1000001];
        for (int num: nums){
            freq[num]++;
            max = Math.max(max, num);
        }
        for (int i = 1; i <= max; i++){
            if (freq[i] == 1)
                return -1;
            int mod = freq[i] % 3;
            if (mod == 1 || mod == 2)
                count += freq[i]/3 + 1;
            else
                count += freq[i]/3;
        }
        return count;
    }
}