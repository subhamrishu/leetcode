class NumArray {
    int low, high;
    int[] tree;
    public NumArray(int[] nums) {
        low = 0;
        high = nums.length;
        tree = new int[high*4+1];
        buildSegmentTree(nums, 1, low, high-1);
    }
    
    public void update(int index, int val) {
        updateSegmentTree(1, low, high-1, index, val);
    }
    
    public int sumRange(int left, int right) {
        return querySegmentTree(1, low, high-1, left, right);
    }
    void buildSegmentTree(int[] nums, int treeIndex, int low, int high){
        if (low > high)
            return;
        if (low == high){
            tree[treeIndex] = nums[low];
            return;
        }
        int mid = low + (high - low)/2;
        int leftChildIndex = 2 * treeIndex, rightChildIndex = 2 * treeIndex + 1;
        buildSegmentTree(nums, leftChildIndex, low, mid);
        buildSegmentTree(nums, rightChildIndex, mid +1 , high);
        
        tree[treeIndex] = tree[leftChildIndex] + tree[rightChildIndex];
    }
    int querySegmentTree(int treeIndex, int low, int high, int left, int right){
        if (low > right || high < left)
            return 0;
        
        if (left == low && right == high)
            return tree[treeIndex];
        
        int mid = low + (high - low)/2;
        
        if (left > mid)
            return querySegmentTree(2 * treeIndex +1, mid + 1, high, left, right);
        else if (right <= mid)
            return querySegmentTree(2 * treeIndex , low, mid, left, right);
        
        int leftQuery =  querySegmentTree(2 * treeIndex , low, mid, left, mid);
        int rightQuery = querySegmentTree(2 * treeIndex + 1, mid+1, high, mid+1, right);
        
        return leftQuery + rightQuery;
    }
    void updateSegmentTree(int treeIndex, int low, int high, int index, int val){
        if (low == high){
            tree[treeIndex] = val;
            return;
        }
        int mid = low + (high - low)/2;
        
        if (index > mid)
            updateSegmentTree(2 * treeIndex + 1, mid + 1, high, index, val);
        else if (index <= mid)
            updateSegmentTree(2 * treeIndex , low, mid, index, val);
        
        tree[treeIndex] = tree[2 * treeIndex ] + tree[2 * treeIndex + 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */