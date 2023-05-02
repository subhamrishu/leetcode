class Solution {
    public int arraySign(int[] nums) {
        int prod = 1;
        for (int num: nums){
            prod *= num == 0 ? 0 : num > 0 ? 1 : -1;
        }
        // System.out.println(prod);
        return prod == 0 ? 0 : prod < 0 ? -1 : 1;
    }
}