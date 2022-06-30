class Node{
    int minValue;
    int val; 
    Node next;
    Node(int val, int minValue, Node next){
        this.val = val;
        this.minValue = minValue;
        this.next = next;
    }
}
class MinStack {
    Node head;
    public MinStack() {
        
    }
    
    public void push(int val) {
        if (head == null){
            head = new Node(val, val, null);
        }
        else{
            int currMin = head.minValue;
            if (val <= currMin)
                head = new Node(val, val, head);
            else
                head = new Node(val, currMin, head);
            // head.next = temp;
        }
        // head = temp;
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;   
    }
    
    public int getMin() {
        return head.minValue;
    }
}
