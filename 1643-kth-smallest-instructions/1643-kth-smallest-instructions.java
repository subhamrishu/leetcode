class Solution {
    public String kthSmallestPath(int[] A, int k) {
        int m = A[0], n = A[1];
        int len = m+n;
        int[][] dp = new int[len+1][len+1];
        dp[0][0] = 1;
        for(int i=1; i<=len; i++) {
            for(int j=0; j<=i; j++) {
                if(j == 0 || j == i) 
                    dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int down = m;
        for(int i=0; i<len; i++) {
            int remain = len - (i+1);
            int com = dp[remain][down];
            if(com >= k) {
                sb.append("H");
            } else {
                down -= 1;
                k -= com;
                sb.append("V");
            }
        }
        return sb.toString();
    } 
    
}