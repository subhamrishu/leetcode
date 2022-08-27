class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] sol = new int[n];
        
        /* ===========using Stack===========
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++){
            while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]){
                int smallerIndex = stack.pop();
                sol[smallerIndex] = i - smallerIndex;
            }
            stack.push(i);
        }
        return sol;
        */
        /*============using Array===========*/
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++){
            while (top > -1 && temperatures[i] > temperatures[stack[top]]){
                int smallerIndex = stack[top--];
                sol[smallerIndex] = i - smallerIndex;
            }
            stack[++top] = i;
        }
        return sol;
    }
}