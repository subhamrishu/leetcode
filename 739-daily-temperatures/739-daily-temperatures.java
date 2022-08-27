class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] sol = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++){
            while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]){
                int smallerIndex = stack.pop();
                sol[smallerIndex] = i - smallerIndex;
            }
            stack.push(i);
        }
        return sol;
    }
}