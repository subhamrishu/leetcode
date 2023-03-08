class Solution {
    int findK(int[] piles, int mid){
        int sum = 0;
        for (int pile: piles){
            sum+= (pile+mid-1)/mid;  
        }
        
        return sum;
    }
    int findOptimalKbyBinarySearch(int low, int high, int h, int[] piles){
        int k=0;
        while (low < high){
            int mid = low + (high - low)/2;
            k = findK(piles, mid);
            if (k > h)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int pile : piles){
            if (pile > max)
                max = pile;
        }
        if (piles.length == h)
            return max;
        return findOptimalKbyBinarySearch(1, max, h, piles);
    }
}