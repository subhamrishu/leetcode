class Solution {
    public int arraySign(int[] nums) {
        int prod = 1;
        for (int num: nums){
            if (num < 0)
                prod = -prod;
            if (num == 0)
                prod = 0;
        }
        // System.out.println(prod);
        return prod;
    }
}