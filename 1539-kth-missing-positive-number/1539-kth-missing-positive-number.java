class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0 ; i < n; i++){
            set.add(arr[i]);
        }
        int count=k, curr = 1;
        while(count!=0){
            if (!set.contains(curr))
                count--;
            curr++;
        }
        return curr-1;
    }
}