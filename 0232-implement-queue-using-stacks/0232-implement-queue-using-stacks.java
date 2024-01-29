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
        // System.out.println("Before push = "+x+" stack 1 = "+s1+" stack 2 = "+s2);
        s1.push(x);
        // System.out.println("\tAfter push = "+x+" stack 1 = "+s1+" stack 2 = "+s2);
        // if (s2.isEmpty())
        //     s2.push(x);
    }
    
    public int pop() {
        // System.out.println("Before pop = " + " stack 1 = "+s1+" stack 2 = "+s2 +" poppedNum = "+poppedNum);
        if (!s2.isEmpty()){
            // poppedNum++;
            total--;
            int top = s2.pop();
            // System.out.println("\tAfter pop = " + " stack 1 = "+s1+" stack 2 = "+s2);
            return top;
        }
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
        // while (poppedNum > 0){
        //     poppedNum--;
        //     s2.pop();
        // }
        // System.out.println("\tAfter pop = " + " stack 1 = "+s1+" stack 2 = "+s2);
        total--;
        return s2.pop();
    }
    
    public int peek() {
        // System.out.print("peek: ");
        int top = pop();
        s2.push(top);
        total++;
        // poppedNum--;
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