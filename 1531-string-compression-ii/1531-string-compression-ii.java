class Solution {
//     Integer[][] dp;
//     int count(int n){
//         int c = 0;
        
//         if (n == 1)
//             return 0;
        
//         while (n > 0){
//             n /= 10;
//             c++;
//         }
//         return c;
//     }
    
//     int compress_length(String s){
//         if (s.length() == 0) return 0;
//         char[] cs = s.toCharArray();
        
//         int i = 0, l = 0, n = cs.length;
//         while (i < s.length()){
//             int j = i;
//             while (i < n-1 && cs[i] == cs[i+1]){
//                 i++;
//             }
//             l += 1 + count(i - j + 1);
//             i++;
//         }
//         System.out.println("compress_length("+s+") = "+l);
//         return l;
//     }
//     int compression(String s, int k, int curr, Map<String, Integer> map){
//         System.out.println("Compression("+s+" "+k+" "+curr+")");
//         if (k == 0 || curr > s.length()-1){
//             // System.out.println("Compression("+s+" "+k+" "+curr+")");
//             return compress_length(s);
//         }
//         if (dp[k][curr] != null){
//             return dp[k][curr];
//             // return map.get(s);
//         }
//         // System.out.println("Compression("+s+" "+k+" "+curr+")"+ " nextIndex[s.charAt(curr-'a')]="+nextIndex[s.charAt(curr)-'a']);
        
//         int n = s.length();
//         int l = compression(s.substring(0,curr)+s.substring(curr+1,n), k-1, curr, map);
//         while (curr < n-1 && s.charAt(curr) == s.charAt(curr+1)){
//             curr++;
//         }
//         curr++;
//         int r = compression(s, k, curr, map);
//         // map.put(s, Math.min(l, r));
//         return dp[k][curr] = Math.min(l, r);
            
//     }
//     public int getLengthOfOptimalCompression(String s, int k) {
//         int n = s.length();
//         // int[] nextIndex = new int[n];
//         char[] cs = s.toCharArray();
//         dp = new Integer[101][101];
// //         int prev = n;
// //         for (int i = n-1; i > 0; i--){
        
// //             nextIndex[i] = prev;
// //            if (cs[i] != cs[i-1])
// //                 prev = i;
// //         }
// //         nextIndex[0] = prev;
//         Map<String, Integer> map = new HashMap<>();
//         return compression(s, k, 0, map);
//     }
    public int getLengthOfOptimalCompression(String s, int K) {
        // dp[i][k]: the minimum length for s[:i] with at most k deletion.
        int n = s.length();
        int[][] dp = new int[n + 1][K + 1];
        for (int[] i : dp) Arrays.fill(i, n);
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int k = 0; k <= K; k++) {
                if (k > 0) // delete s[i]
                    dp[i][k] = Math.min(dp[i][k], dp[i - 1][k - 1]);

                // keep s[i], concat the same, remove the different
                int same = 0, diff = 0;
                for (int j = i; j >= 1; j--) {
                    if (s.charAt(j - 1) == s.charAt(i - 1)) same++;
                    else diff++;
                    if (diff > k) break;
                    // baaaaaaccaaaa  k=2, s[i] = a, j will extend to index 1
                    dp[i][k] = Math.min(dp[i][k], dp[j - 1][k - diff] + getLen(same)); 
                }
            }
        }
        return dp[n][K];
    }

    private int getLen(int count) {
        if (count == 1) return 1;
        else if (count < 10) return 2;
        else if (count < 100) return 3;
        else return 4;
    }
}