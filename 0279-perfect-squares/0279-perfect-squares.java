class Solution {
    int helper1(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        int max_squares_num = (int)Math.sqrt(n)+1;
        int[] squares = new int[max_squares_num];
        
        for (int i = 1; i < max_squares_num; i++){
            squares[i] = i * i;
        }
        
        for (int i = 1; i <= n; i++){
            for (int j = 1; j < max_squares_num; j++){
                if (i < squares[j])
                    break;
                dp[i] = Math.min(dp[i], dp[i-squares[j]] + 1);
            }
        }
        return dp[n];
    }
    public int numSquares(int n) {
       // return helper1(n);
        int max_squares_num = (int)Math.sqrt(n)+1;
        int[] squares = new int[max_squares_num];
        
        for (int i = 1; i < max_squares_num; i++){
            squares[i] = i * i;
        }
        Set<Integer> q = new HashSet<>();
        q.add(n);
        int level = 0;
        
        while (!q.isEmpty()){
            level += 1;
            Set<Integer> q_temp = new HashSet<>();
            for (Integer remainder: q){
                for (int i = 1; i < max_squares_num; i++){
                    if (remainder < squares[i])
                        break;
                    else if (remainder == squares[i])
                        return level;
                    q_temp.add(remainder - squares[i]);
                }
            }
            q = q_temp;
        }
        return level;
    }
}