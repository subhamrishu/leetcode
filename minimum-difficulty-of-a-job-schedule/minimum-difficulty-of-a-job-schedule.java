class Solution {
    Integer[][] dp;
    int jobSchedule(int[] jobs, int curr, int d){
        if (dp[curr][d] != null)
            return dp[curr][d];
        // System.out.println("curr = "+curr+" d="+d);
        if ((jobs.length - curr) < d || d < 0)
            return -1;
//         if (curr == jobs.length){
//             if (d == 0)
//                 return 0;
//             else
//                 return -1;
//         }
        
        int max = 0, min = Integer.MAX_VALUE;
        
        if (d == 1){
            for (int i = curr; i < jobs.length; i++){
                max = Math.max(max, jobs[i]);
            }
            return dp[curr][d] = max;
        }
        for (int k = curr; k <= jobs.length-d; k++){
            max = Math.max(max, jobs[k]);
            int cost = jobSchedule(jobs, k+1, d-1) + max;
            min = Math.min(min, cost);
            
        }
        // System.out.println("\t" +min);
        return dp[curr][d] = min == Integer.MAX_VALUE? -1 : min;
        // return dp[curr][d];
    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d)
            return -1;
        dp = new Integer[n][d+1];
        
        return jobSchedule(jobDifficulty, 0, d);
    }
}