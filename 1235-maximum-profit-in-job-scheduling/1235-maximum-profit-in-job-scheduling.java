// class Solution {
//     class Jobs{
//         int startTime, endTime, profit;
//         Jobs(int s, int e, int p){
//             startTime = s;
//             endTime = e;
//             profit = p;
//         }
//     }
//     Integer[][] dp;
//     int getMaxProfit(Jobs[] jobs, int curr, int lastIndex){
//         if (curr == jobs.length)
//             return 0;
//         if (dp[curr][lastIndex+1] != null)
//             return dp[curr][lastIndex+1];
//         int l = 0; 
//         if (lastIndex == -1 || jobs[curr].startTime >= jobs[lastIndex].endTime){
//             l = jobs[curr].profit + getMaxProfit(jobs, curr + 1, curr);
//         }
//         int r = getMaxProfit(jobs, curr + 1, lastIndex);
//         // System.out.println("curr = "+curr+" lastEndTime = "+lastIndex + " profit = "+ Math.max(l, r));
//         return dp[curr][lastIndex+1] = Math.max(l, r);
//     }
//     int getMaxProfitOLd(Jobs[] jobs, int curr, int lastIndex){
//         if (curr == jobs.length)
//             return 0;
//         // if (dp[curr][lastIndex+1] != null)
//         //     return dp[curr][lastIndex];
//         int l = 0; 
//         if (lastIndex == -1 || jobs[curr].startTime >= jobs[lastIndex].endTime){
//             l = jobs[curr].profit + getMaxProfit(jobs, curr + 1, curr);
//         }
//         int r = getMaxProfit(jobs, curr + 1, lastIndex);
//         System.out.println("curr = "+curr+" lastEndTime = "+lastIndex + " profit = "+ Math.max(l, r));
//         return Math.max(l, r);
//     }
//     public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
//         int n = startTime.length;
//         Jobs[] jobs = new Jobs[n];
//         int[] DP = new int[n];
//         for (int i = 0; i < n; i++){
//             jobs[i] = new Jobs(startTime[i], endTime[i], profit[i]);
//             DP[i] = profit[i];
//         }
//         Arrays.sort(jobs, (a, b) -> a.startTime - b.startTime);
//         // dp = new Integer[n+1][n+1];
//         // for (int i = 0; i < n; i++){
//         //     System.out.println("i = "+i+ " " + jobs[i].startTime);
//         // }
//         // return 0;
        
//         int max = 0;
//         for (int i = 0; i < n; i++){
//             for (int j =0; j<i; j++){
//                 if (jobs[i].startTime >= jobs[j].endTime){
//                     DP[i] = Math.max(DP[i], DP[j] + jobs[i].profit);
//                 }
//             }
//             max = Math.max(max, DP[i]);
//         }
//         // System.out.println(Arrays.toString(DP));
//         return max;
//         // return getMaxProfit(jobs, 0, -1);
//     }
// }
class Solution {
    // maximum number of jobs are 50000
    int[] memo = new int[50001];
    
    private int findNextJob(int[] startTime, int lastEndingTime) {
        int start = 0, end = startTime.length - 1, nextIndex = startTime.length;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            if (startTime[mid] >= lastEndingTime) {
                nextIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return nextIndex;
    }
    
    private int findMaxProfit(List<List<Integer>> jobs, int[] startTime, int n, int position) {
        // 0 profit if we have already iterated over all the jobs
        if (position == n) {
            return 0;
        }
        
        // return result directly if it's calculated 
        if (memo[position] != -1) {
            return memo[position];
        }
        
        // nextIndex is the index of next non-conflicting job
        int nextIndex = findNextJob(startTime, jobs.get(position).get(1));
        
        // find the maximum profit of our two options: skipping or scheduling the current job
        int maxProfit = Math.max(findMaxProfit(jobs, startTime, n, position + 1), 
                        jobs.get(position).get(2) + findMaxProfit(jobs, startTime, n, nextIndex));
        
        // return maximum profit and also store it for future reference (memoization)
        return memo[position] = maxProfit;
    }
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<List<Integer>> jobs = new ArrayList<>();
        
        // marking all values to -1 so that we can differentiate 
        // if we have already calculated the answer or not
        Arrays.fill(memo, -1);
        
        // storing job's details into one list 
        // this will help in sorting the jobs while maintaining the other parameters
        int length = profit.length;
        for (int i = 0; i < length; i++) {
            ArrayList<Integer> currJob = new ArrayList<>();
            currJob.add(startTime[i]);
            currJob.add(endTime[i]);
            currJob.add(profit[i]);
            jobs.add(currJob);
        }
        jobs.sort(Comparator.comparingInt(a -> a.get(0)));
        
        // binary search will be used in startTime so store it as separate list
        for (int i = 0; i < length; i++) {
            startTime[i] = jobs.get(i).get(0);
        }
        
        return findMaxProfit(jobs, startTime, length, 0);
    }
}