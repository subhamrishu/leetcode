class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if(n1 == 0){
            return nums2[(n2 - 1) / 2] * 0.5 + nums2[n2 / 2] * 0.5;
        }
        if(n2 == 0){
            return nums1[(n1 - 1) / 2] * 0.5 + nums1[n1 / 2] * 0.5;
        }
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);
        
        int lo = 0, hi = n1;
        while (lo <= hi){
            int cut1 = (lo + hi)/2;
            int cut2 = (n1 + n2 + 1)/2 - cut1;
            // System.out.println("lo="+lo+" hi="+hi+" cut1="+cut1+" cut2="+cut2);
            int l1 = !(cut1 > 0) ? Integer.MIN_VALUE: nums1[cut1-1];
            int l2 = !(cut2 > 0) ? Integer.MIN_VALUE: nums2[cut2-1];
            int r1 = !(cut1 < n1) ? Integer.MAX_VALUE: nums1[cut1];
            int r2 = !(cut2 < n2) ? Integer.MAX_VALUE: nums2[cut2];
            
            if(l1 <= r2 && l2 <= r1){
                if ((n1+n2)%2 == 0){
                    return (Math.max(l1, l2)+Math.min(r1,r2))/2.0;
                }
                else
                    return Math.max(l1, l2);
            }
            else if (l1 > r2)
                hi = cut1 - 1;
            else
                lo = cut1 + 1;
        }
        return 0.0;
        
    }
}