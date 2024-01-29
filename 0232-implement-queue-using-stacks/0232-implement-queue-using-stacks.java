class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    int poppedNum;
    int total = 0;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        poppedNum = 0;
        
    }
    
    public void push(int x) {
        total++;
        s1.push(x);
    }
    
    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        total--;
        return s2.pop();
    }
    
    public int peek() {
        int top = pop();
        s2.push(top);
        total++;
        return top;
    }
    
    public boolean empty() {
        return total == 0;       
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */