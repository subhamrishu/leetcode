class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumOfOccurences = new HashMap<>();
        int sum = 0;
        sumOfOccurences.put(0, 1);
        int sol = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (sumOfOccurences.containsKey(sum-k))
                sol += sumOfOccurences.get(sum-k);
            sumOfOccurences.put(sum, sumOfOccurences.getOrDefault(sum, 0)+1);
        }
        return sol;
    }
}