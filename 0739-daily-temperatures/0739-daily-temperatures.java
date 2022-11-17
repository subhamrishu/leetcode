class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] sol = new int[n];
        sol[n-1] = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(n-1);
        for (int i = n-2; i >= 0; i--){
            while (stack.size() > 0 && temperatures[stack.peek()] <= temperatures[i]){
                stack.pop();
            }
            sol[i] = stack.size() > 0 ? stack.peek() - i : 0;
            stack.push(i);
        }
        return sol;
    }
}