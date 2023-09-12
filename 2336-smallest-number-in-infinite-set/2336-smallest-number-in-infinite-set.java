class SmallestInfiniteSet {
    SortedSet<Integer> ss;
    int n;
    public SmallestInfiniteSet() {
        n = 1;
        ss = new TreeSet<>();
    }
    
    public int popSmallest() {
        int sol;
        if (!ss.isEmpty()){
            sol = ss.first();
            ss.remove(sol);
        }else{
            sol = n;
            n += 1;
        }
        return sol;
    }
    
    public void addBack(int num) {
        if (n <= num || ss.contains(num))
            return;
        ss.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */