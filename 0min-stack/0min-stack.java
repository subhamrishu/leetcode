class MinStack {
    
    List<int[]> stack;
    
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        int min = Integer.MAX_VALUE;
        if (stack.size() == 0){
            min = val;
        }else{
            min = Math.min(stack.get(stack.size()-1)[1], val);
        }
        
        // System.out.println("min = "+min);
        stack.add(new int[]{val, min});
    }
    
    public void pop() {
        stack.remove(stack.size() - 1);
    }
    
    public int top() {
        return stack.get(stack.size()-1)[0];
    }
    
    public int getMin() {
        // System.out.println(Arrays.toString(stack.get(stack.size()-1)));
        return stack.get(stack.size()-1)[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */