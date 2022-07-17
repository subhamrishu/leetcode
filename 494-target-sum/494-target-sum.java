class Solution {
    Map<String, Integer> map;
    int findTargetSumWays(int[] nums, int target, int currInd){
        if (nums.length == currInd)
            return target == 0 ? 1 : 0;
        if (map.containsKey(target+"->"+currInd))
            return map.get(target+"->"+currInd);
        int numOfWays = findTargetSumWays(nums, target+nums[currInd], currInd+1) +
                findTargetSumWays(nums, target-nums[currInd], currInd+1);
        map.put(target+"->"+currInd, numOfWays);
        return numOfWays;
    }
    public int findTargetSumWays(int[] nums, int target) {
        map = new HashMap();
        // System.out.println(map);
        return findTargetSumWays(nums, target, 0);
    }
}