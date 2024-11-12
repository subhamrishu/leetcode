class MyCircularQueue {

    int[] queue;
    int front = -1, rear = -1;
    int K;
    public MyCircularQueue(int k) {
        queue = new int[k];
        K = k;
    }
    
    public boolean enQueue(int value) {
        int nextPos = (rear + 1) % K;
        // System.out.println("Front = "+front+" rear = "+rear+" arr[]="+Arrays.toString(queue));
        if (!isFull()){ 
            if (isEmpty())
                front = 0;
            queue[nextPos] = value;
            rear = nextPos;
            // System.out.println("Front = "+front+" rear = "+rear+" arr[]="+Arrays.toString(queue));
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        // System.out.println("Front = "+front+" rear = "+rear+" arr[]="+Arrays.toString(queue));
        
        if (!isEmpty()){
            if(front == rear){
                front = -1;
                rear = -1;
            }else
                front = (front + 1) % K;

            return true;
        }
        return false;
    }
    
    public int Front() {
        if (isEmpty()) return -1;
        // int nextPos = (front + 1) % K;
        return queue[front];
    }
    
    public int Rear() {
        // System.out.println("REAR() rear = "+rear);
        if (isEmpty()) return -1;
        // int nextPos = (rear + 1) % K;
        return queue[rear];
    }
    
    public boolean isEmpty() {
        return (front == -1 || rear == -1);
    }
    
    public boolean isFull() {
        int nextPos = (rear + 1) % K;
        return (nextPos == front);
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */