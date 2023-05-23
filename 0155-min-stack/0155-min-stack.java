class MinStack {
    class Node {
        int val;
        int min;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }
    Node head = null;
    public MinStack() {
        
    }
    
    public void push(int val) {
        Node node = new Node(val);
        if(head == null){
            node.min = val;
        }else{
            node.min = Math.min(head.min, val);
        }
        node.next = head;
        head = node;
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
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