class OrderedStream {
    
    String[] list;
    int pos = 1;
    public OrderedStream(int n) {
        list = new String[n+1];
        
        // System.out.println()
    }
    
    public List<String> insert(int idKey, String value) {
        list[idKey] = value;
        List<String> sol = new ArrayList<>();
        int idx = idKey;
        if (pos == idKey){
            while(pos < list.length && list[pos] != null)
                sol.add(list[pos++]);
        }
        return sol;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */