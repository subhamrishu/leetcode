class Solution {
    int distanceFromOrigin(int[] p){
        return p[0]*p[0] + p[1]*p[1];
    }
    void swap(int[][] points, int i, int j){
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
    int partition(int[][] points, int lo, int hi){
        int pivotDist = distanceFromOrigin(points[hi]);
        int i = lo-1, j = lo;
        while (j < hi){
            if (distanceFromOrigin(points[j]) <= pivotDist){
                i++;
                swap(points, i, j);
            }
            j++;
        }
        swap(points, i+1, j);
        return i+1;
    }
    int[][] quickSort(int[][] points, int k){
        int pivot = points.length;
        int lo = 0, hi = points.length - 1;
        while (lo < hi){
            pivot = partition(points, lo, hi);
            if (pivot < k)
                lo = pivot+1;
            else if (pivot > k)
                hi = pivot-1;
            else 
                break;
        }
        return Arrays.copyOf(points, k);
    }
    public int[][] kClosest(int[][] points, int k) {
        return quickSort(points, k);
    }
}