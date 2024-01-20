class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;
        
        long minSum = 0;
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        
        for (int i = 0; i <= n; i++){
            while (!stack.empty() && (i == n || arr[stack.peek()] >= arr[i])){
                int mid = stack.pop();
                int leftBoundary = stack.empty() ? -1 : stack.peek();
                int rightBoundary = i;
                
                long numOfSubArray = ((mid - leftBoundary) * (rightBoundary - mid)) % MOD;
                minSum = (minSum + arr[mid] * numOfSubArray) % MOD;
                minSum = minSum % MOD;
            }
            stack.push(i);
        }
        return (int)minSum;
    }
}