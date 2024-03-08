class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int max = 0;
        for (int num: nums){
            freq[num]++;
            max = Math.max(max, freq[num]);
        }
        int count = 0;
        for (int i = 0; i <=100; i++){
            if (freq[i] == max)
                count += freq[i];
        }
        return count;
    }
}