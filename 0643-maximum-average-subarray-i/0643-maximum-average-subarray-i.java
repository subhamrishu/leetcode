class Solution {
    public double findMaxAverage(int[] nums, int k) {
        long sum = 0;
        for (int i = 0; i < k; i++){
            sum += nums[i];
        }
        double avg = sum*1.0/k;
        // System.out.println(sum+" "+avg);
        for (int i = k; i < nums.length; i++){
            sum -= nums[i-k];
            sum += nums[i];
            if (sum*1.0/k > avg)
                avg = sum*1.0/k;
        }
        return avg;
    }
}