class Solution {
    int findK(int[] piles, int mid){
        int sum = 0;
        // System.out.println(mid+"========");
        for (int pile: piles){
            sum+= Math.ceil((double)pile/mid);   
            // System.out.println(sum);
        }
        
        return sum;
    }
    int findOptimalKbyBinarySearch(int low, int high, int h, int[] piles){
        int k=0;
        while (low <= high){
            int mid = low + (high - low)/2;
            k = findK(piles, mid);
            // System.out.println(low + " "+ high + " "+mid + " "+k);
            if (k > h)
                low = mid + 1;
            else
                high = mid - 1;
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
        return findOptimalKbyBinarySearch(0, max, h, piles);
    }
}