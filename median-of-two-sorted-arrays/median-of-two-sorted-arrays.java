class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        //if either of the arrays are of zero length, we directly get the middle element(s) and return the median
        //note for even: size = 6, 6/2 = 3 and 5/2 = 2; (nums[2]+nums[3])/2
        if (n1 == 0){
            return (nums2[n2/2] + nums2[(n2-1)/2])/2.0;
        }
        if (n2 == 0){
            return (nums1[n1/2] + nums1[(n1-1)/2])/2.0;
        }
        // we are assuming length of nums1 to be shorter; so if length of nums1 is larger than nums2 then reverse order 
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);
        
        int lo = 0, hi = n1, middle = (n1+n2+1)/2; //we are keeping our binary search space for shorter array 
        while (lo <= hi){
            int mid1 = (lo + hi)/2;
            int mid2 = middle - mid1;
            
            int l1 = (mid1 == 0) ? Integer.MIN_VALUE: nums1[mid1-1];
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE: nums2[mid2-1];
            int r1 = (mid1 == n1) ? Integer.MAX_VALUE: nums1[mid1];
            int r2 = (mid2 == n2) ? Integer.MAX_VALUE: nums2[mid2];
            
            if (l1 <= r2 && l2 <= r1){
                if ((n1 + n2)%2 == 0){
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
                }else
                    return Math.max(l1, l2);
            }
            if (l1 > r2){
                hi = mid1 - 1;
            }else{
                lo = mid1 + 1;
            }
        }
        return 0.0;
    }
}