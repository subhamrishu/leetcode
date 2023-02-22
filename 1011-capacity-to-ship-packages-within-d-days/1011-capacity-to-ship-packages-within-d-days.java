class Solution {
    boolean currWtPossible(int[] weights, int mid, int days){
        int totalDay = 1, curr = 0;
        for (int wt: weights){
            curr += wt;
            if (curr > mid){
                totalDay++;
                curr = wt;
            }
        }
        return totalDay <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        
        int maxWt = 0, max = 0;
        for (int wt: weights){
            maxWt += wt;
            max = Math.max(max, wt);
        }
        int l = max, r = maxWt;
        while (l < r){
            int mid = l + (r-l)/2;
            if (currWtPossible(weights, mid, days))
                r = mid;
            else
                l = mid + 1;
            
        }
        return l;
    }
}