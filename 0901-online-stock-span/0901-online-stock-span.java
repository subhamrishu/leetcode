class StockSpanner {
    Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int cnt = 1;
        while (!stack.isEmpty() && price >= stack.peek()[0]){
            cnt+= stack.peek()[1];
            stack.pop();
        }
        stack.push(new int[]{price, cnt});
        return cnt;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */