class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] sol = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < n; i++){
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                sol[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
            
        }
        return sol;
    }
}