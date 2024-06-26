class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxFreq;

    public FreqStack() {
        freq = new HashMap();
        group = new HashMap();
        maxFreq = 0;    
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        if (f > maxFreq) maxFreq = f;

        group.computeIfAbsent(f, x -> new Stack<>()).push(val);
    }
    
    public int pop() {
        int val = group.get(maxFreq).pop();
        freq.put(val, freq.get(val)-1);

        if (group.get(maxFreq).size() == 0)
            maxFreq--;
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */