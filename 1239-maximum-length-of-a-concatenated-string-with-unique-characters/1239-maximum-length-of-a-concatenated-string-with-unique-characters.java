// class Solution {
    // Integer[] dp;
//     boolean isUnique(String temp){
//         int[] freq = new int[26];
//         for (char ch: temp.toCharArray()){
//             freq[ch-'a']++;
//             if (freq[ch-'a'] > 1)
//                 return false;
//         }
//         return true;
//     }
//     int concat(List<String> arr, int curr, String combined){
//         // System.out.println("concat(curr = " + curr + " combined = " + combined + ")");
//         if (curr == arr.size()){
//             if (isUnique(combined))
//                 return combined.length();
//             return 0;
//         }
        
//         // if (dp[curr] != null)
//         //     return dp[curr];
        
//         String temp = combined + arr.get(curr);
//         int a =0, b=0, c=0;
//         if (isUnique(temp)){
//             //take the combined string and iterate
//             a = concat(arr, curr+1, new String(temp));
//         }
//             //dont take the combined string, go ahead with what was passed
//         b = concat(arr, curr+1, combined);
        
//         //leave the old string and take the string at position curr
//         c = concat(arr, curr+1, arr.get(curr));
        
//         return Math.max(a, Math.max(b, c));
        
//     }
//     public int maxLength(List<String> arr) {
//         // dp = new Integer[arr.size()];
//         return concat(arr, 0, "");
//         // System.out.println(Arrays.toString(dp));
//         // return dp[0];
//     }
// }
class Solution {
    public int maxLength(List<String> arr) {
        // Use depth first search recursion through arr
        // building from an initial empty string
        return dfs(arr, 0, "");
    }

    private int dfs(List<String> arr, int pos, String res) {    
        // Use a set to check res for duplicate characters
        Set<Character> resSet = new HashSet<>();
        for (char c : res.toCharArray())
            resSet.add(c);
        if (res.length() != resSet.size())
            return 0;

        // Recurse through each possible next option
        // and find the best answer
        int best = res.length();
        for (int i = pos; i < arr.size(); i++)
            best = Math.max(best, dfs(arr, i + 1, res + arr.get(i)));
        return best;
    }
}