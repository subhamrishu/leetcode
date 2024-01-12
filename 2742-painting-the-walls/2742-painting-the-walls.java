class Solution {
    int INF = 250000009;
    int helper(int[] cost, int[] time, int freeTime, int curr, Map<Integer, Integer>[] memo){
        if (curr == cost.length)
            return freeTime >= 0 ? 0 : INF;
        if (cost.length - curr <= freeTime)
            return 0;
        if (memo[curr].containsKey(freeTime)) return memo[curr].get(freeTime);
        
        int paid = cost[curr] + helper(cost, time, freeTime+time[curr], curr+1, memo);
        int free = helper(cost, time, freeTime-1, curr+1, memo);
        memo[curr].put(freeTime, Math.min(paid, free));
        return memo[curr].get(freeTime);
    }
    public int paintWalls(int[] cost, int[] time) {
        Map<Integer, Integer>[] memo = new Map[cost.length];
        for (int i = 0; i < cost.length; i++){
            memo[i] = new HashMap<>();
        }
        return helper(cost, time, 0, 0, memo);
        
    }
}