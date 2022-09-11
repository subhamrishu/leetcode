class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        //we make sure that A's size is smaller then B's
        if (A.length > B.length)
            return findMedianSortedArrays(B, A);
        
        
        int aSize= A.length;
        int bSize = B.length;
        
        int minAcontri = 0; // min contribution size of A can be 0
        int maxAcontri = aSize; //max contribution size of A can be aSize
        
        while (minAcontri <= maxAcontri){
            int contriA = (minAcontri + maxAcontri)/2; //take mid of A and see if the contribution is sufficient 
            int contriB = (aSize + bSize + 1)/2 - contriA;//accordingly we adjust the contribution of B
            
            /*if contribution of A for first half is 0 then there's nothing 
            on the left side of A. so we use -INF for maxLeftA
            if contribution of A for first half is length of input then there's nothing 
            on the right side of A. so we use +INF for minRightA
            */
            // System.out.println("contriA = "+contriA + " contriB="+contriB);
            int maxLeftA = (contriA == 0) ? Integer.MIN_VALUE : A[contriA-1];
            int minRightA = (contriA == aSize) ? Integer.MAX_VALUE : A[contriA];
            int maxLeftB = (contriB == 0) ? Integer.MIN_VALUE : B[contriB-1];
            int minRightB = (contriB == bSize) ? Integer.MAX_VALUE : B[contriB];
            
            if (maxLeftA <= minRightB && maxLeftB <= minRightA){ //if this is true then we have the right
                //contribution by A and B for the first half now we will calculate the median
                //we check if the combined length is even or odd
                if ((aSize + bSize) % 2 == 0) //if even return the avg of mid elements which will be 
                    //max of left side of A or B and min of right of A or B
                    return (double) (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB))/2;
                else
                    return Math.max(maxLeftA, maxLeftB);
            }
            else if(maxLeftA > minRightB) //this means that we have contributed more 
                //elements of A then we needed to; we need to decrease the range
                maxAcontri = contriA - 1;
            else //this means that we have contributed less elements of A, we need to increase the range
                minAcontri = contriA + 1;
        }
        return -1;
    }
}