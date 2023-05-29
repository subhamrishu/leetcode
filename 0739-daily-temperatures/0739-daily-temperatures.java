class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] sol = new int[n];
        Arrays.fill(sol, 0);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            while(stack.size() !=0 && temperatures[stack.peek()] < temperatures[i]){
                sol[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return sol;
    }
}