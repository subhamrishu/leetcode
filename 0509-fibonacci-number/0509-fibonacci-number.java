class Solution {
    // int[] memo = new int[31];
    // public int fib(int n) {
    //     if (n <= 1)
    //         return n;
    //     if (memo[n] != 0)
    //         return memo[n];
    //     return memo[n] = fib(n-1) + fib(n-2);
    // }
    public int fib(int n) {
        if (n <= 1)
            return n;
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <=n; i++){
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }
}