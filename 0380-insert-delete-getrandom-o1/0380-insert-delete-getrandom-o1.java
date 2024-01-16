class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random rand;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)){
           return false;
        }
        int idx = list.size();
        map.put(val, idx);
        list.add(val);
        return true;
        
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        
        int idx = map.get(val);
        int idx_last = list.size()-1;
        int val_last = list.get(idx_last);
        
        list.set(idx, list.get(idx_last));
        map.put(val_last, idx);
        list.remove(idx_last);
        
        map.remove(val);
        
        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */