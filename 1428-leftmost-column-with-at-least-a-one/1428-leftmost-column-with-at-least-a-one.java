/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    // boolean binarySearch(int col, int numOfrows, BinaryMatrix mat){
    //     int lo = 0, hi = numOfrows-1;
    //     while (lo <= hi){
    //         int mid = lo + (hi - lo)/2;
    //         if (mat.get(mid, col) == 1)
    //             return true;
    //         lo = mid + 1;
    //     }
    //     return false;
    // }
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int m = dim.get(0), n = dim.get(1);
        int r = 0, c = n-1, least = -1;
        
        while (r < m && c >= 0){
            if (binaryMatrix.get(r, c) == 1){
                least = c;
                c--;
            }
            else 
                r++;
        }
        return least;
    }
}