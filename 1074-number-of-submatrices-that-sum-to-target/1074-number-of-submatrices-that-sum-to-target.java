// class Solution {
//     int dp[][];
//     Set <String> set;
//     boolean isMoveInvalid(int r1, int r2, int c1, int c2, int r, int c){
//          if (r1 < 0 || c1 < 0 || r2 < 0 || c2 < 0 || r1 == r || r2 == r || c1 == c || c2 == c||r1 > r2||c1 > c2)
//             return true;
//         return false;
//     }
//     int sumOfMatrix(int r1, int r2, int c1, int c2){
//         return dp[r2 + 1][c2 + 1] - dp[r2 + 1][c1] - dp[r1][c2 + 1] + dp[r1][c1];
//     }
//     int helper(int matrix[][], int target, int r1, int r2, int c1, int c2){
//         int r = matrix.length, c = matrix[0].length;
//         String s = r1 +"#"+r2+"#"+c1+"#"+c2;

//         if (set.contains(s) || isMoveInvalid(r1, r2, c1, c2, r, c))
//             return 0;
//         int count = 0;
//         if (sumOfMatrix(r1, r2, c1, c2) == target)
//             count  += 1;
//         set.add(s);
//         count += helper(matrix, target, r1 + 1, r2, c1, c2) +
//             helper(matrix, target, r1, r2+1, c1, c2) +
//             helper(matrix, target, r1, r2, c1+1, c2)+
//             helper(matrix, target, r1, r2, c1, c2+1);
//         // System.out.println(count);
//         return count;
//     }
//     public int numSubmatrixSumTarget(int[][] matrix, int target) {
//         int r = matrix.length, c = matrix[0].length;
//         set = new HashSet();
//         dp = new int[r+1][c+1];
//         for (int i = 1; i<=r; i++){
//             for (int j =1; j<=c; j++){
//                 dp[i][j] = dp[i][j-1]+dp[i-1][j]-dp[i-1][j-1]+matrix[i-1][j-1];
//             }
//         }
//         // System.out.println(Arrays.deepToString(dp));
//         // System.out.println(sumOfMatrix(0, 2, 0, 0));
//         return helper(matrix, target, 0, 0, 0, 0);
//     }
// }
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int count = 0;
        int line = matrix.length;
        int column = matrix[0].length + 1;
        int[][] sum = new int[line][column];
        
        for (int i = 0; i < sum.length; i++){
            for (int j = 1; j < sum[0].length; j++){
                sum[i][j] = sum[i][j - 1] + matrix[i][j - 1];
            }
        }
        
        
        for (int start = 0; start < column; start++){
            for (int end = start + 1; end < column; end++ ){
                
                int sumOfSubMatrix = 0;
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                map.put(0, 1);
                for(int l = 0; l < line; l++){
                    sumOfSubMatrix += sum[l][end] - sum[l][start];
                    if (map.containsKey(sumOfSubMatrix - target))
                        count += map.get(sumOfSubMatrix - target);
                    map.put(sumOfSubMatrix, map.getOrDefault(sumOfSubMatrix, 0) + 1);
                    
                }
            }
        }
        
        return count;
        
    }
}