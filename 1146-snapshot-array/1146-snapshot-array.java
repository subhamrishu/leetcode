class SnapshotArray {
    ArrayList<HashMap<Integer, Integer>> list;
    int currSnap;
    public SnapshotArray(int length) {
        list = new ArrayList<>();
        currSnap = 0;
        for (int i = 0; i < length; i++){
            list.add(new HashMap<>());
            list.get(i).put(0,0);
        }
    }
    
    public void set(int index, int val) {
        list.get(index).put(currSnap, val);
    }
    
    public int snap() {
        return currSnap++;
    }
    
    public int get(int index, int snap_id) {
        for (int i = snap_id; i >= 0; --i){
            if(list.get(index).containsKey(i))
                return list.get(index).get(i);
        }
        // if(list.get(index).containsKey(snap_id))
        //     return list.get(index).get(snap_id);
        // else
            return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */