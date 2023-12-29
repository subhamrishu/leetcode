class Solution {
    // private Map<String, Integer> memo = new HashMap<>();
    // Integer[][][] dp;
//     public int jobSchedule(int[] jobs, int d, int max, int sum, int curr) {
//         // String key = d + "-" + curr;
//         if (dp[d][curr] != null) {
//             return dp[d][curr];
//         }

//         if (curr == jobs.length && d == 0) {
//             return sum;
//         }
//         if (curr == jobs.length || d == 0) {
//             return -1;
//         }

//         int l = jobSchedule(jobs, d, Math.max(max, jobs[curr]), sum, curr + 1);
//         int r = jobSchedule(jobs, d - 1, Integer.MIN_VALUE, sum + Math.max(max, jobs[curr]), curr + 1);
//         int result = (l == -1 || r == -1) ? Math.max(l, r) : Math.min(l, r);

//         dp[d][curr] = result;
//         // memo.put(key, result);
//         return result;
//     }
//     int jobSchedule(int[] jobs, int d, int max, int sum, int curr){
//         // System.out.println("jobSchedule(d="+d+", max="+max+" ,sum="+sum+", curr="+curr+")");
//         if (curr == jobs.length && d == 0){
//             // System.out.println("    sum = "+sum);
//             return sum;
//         }
//         if (curr == jobs.length || d == 0)
//             return -1;
        
//         // if (dp[d][curr][sum] != null) {
//         //     return dp[d][curr][sum];
//         // }
        
//         int l = jobSchedule(jobs, d, Math.max(max, jobs[curr]), sum, curr+1);
//         int r = jobSchedule(jobs, d-1, Integer.MIN_VALUE, sum+Math.max(max, jobs[curr]), curr+1);
//         int x = (l == -1 || r == -1) ? Math.max(l, r) : Math.min(l, r);
//         // System.out.println("    x = "+x);
//         // dp[d][curr][sum] = x;
//         return x;
//     }
//     public int minDifficulty(int[] jobDifficulty, int d) {
//         // dp = new Integer[11][301][510000];
//         return jobSchedule(jobDifficulty, d, Integer.MIN_VALUE, 0, 0);
//     }
    public int minDifficulty(int[] jobDifficulty, int d) {

        int n = jobDifficulty.length;
        // Edge case: make sure there is at least one job per day
        if (n < d) {
            return -1;
        }

        int[][] mem = new int[n][d + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= d; j++) {
                mem[i][j] = -1;
            }
        }

        return minDiff(0, d, jobDifficulty, mem);
    }

    private int minDiff(int i, int daysRemaining, int[] jobDifficulty, int[][] mem) {
        // Use memoization to avoid repeated computation of states
        if (mem[i][daysRemaining] != -1) {
            return mem[i][daysRemaining];
        }

        // Base case: finish all remaining jobs in the last day
        if (daysRemaining == 1) {
            int res = 0;
            for (int j = i; j < jobDifficulty.length; j++) {
                res = Math.max(res, jobDifficulty[j]);
            }
            return res;
        }

        int res = Integer.MAX_VALUE;
        int dailyMaxJobDiff = 0;
        // Iterate through possible starting index for the next day
        // and ensure we have at least one job for each remaining day.
        for (int j = i; j < jobDifficulty.length - daysRemaining + 1; j++) {
            dailyMaxJobDiff = Math.max(dailyMaxJobDiff, jobDifficulty[j]);
            res = Math.min(res, dailyMaxJobDiff + minDiff(j + 1, daysRemaining - 1, jobDifficulty, mem));
        }
        mem[i][daysRemaining] = res;
        return res;
    }

}