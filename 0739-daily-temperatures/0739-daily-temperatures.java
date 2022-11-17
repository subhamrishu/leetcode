class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] sol = new int[n];
        sol[n-1] = 0;
        // Stack<Integer> stack = new Stack<>();
        int[] stack = new int[n];
        int top = -1;
        // stack.push(n-1);
        stack[++top] = n-1; 
        for (int i = n-2; i >= 0; i--){
            while (top > -1 && temperatures[stack[top]] <= temperatures[i]){
                top--;
            }
            sol[i] = top > -1 ? stack[top] - i : 0;
            stack[++top] = i;
        }
        return sol;
    }
}