class Solution {
     class Jobs{
        int startTime, endTime, profit;
        Jobs(int s, int e, int p){
            startTime = s;
            endTime = e;
            profit = p;
        }
    }
    Integer[] dp;
    int nextFeasibleJob(Jobs[] jobs, int lastEndTime){
        int lo = 0, hi = jobs.length-1, nextIdx = jobs.length;
        
        while (lo <= hi){
            int mid = lo + (hi - lo)/2;
            if (jobs[mid].startTime >= lastEndTime){
                nextIdx = mid;
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return nextIdx;
    }
    int findMaxProfit(Jobs[] jobs, int curr){
        if (curr == jobs.length)
            return 0;
        if (dp[curr] != null)
            return dp[curr];
        int nextIdx = nextFeasibleJob(jobs, jobs[curr].endTime);
        
        int dontTake = findMaxProfit(jobs, curr+1);
        int take = jobs[curr].profit + findMaxProfit(jobs, nextIdx);
        return dp[curr] = Math.max(take, dontTake);
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Jobs[] jobs = new Jobs[n];
        for (int i = 0; i < n; i++){
            jobs[i] = new Jobs(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, (a, b) -> a.startTime - b.startTime);
        dp = new Integer[n+1];
        return findMaxProfit(jobs, 0);
    }
}