class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0, hi = numbers.length-1;
        int[] sol = new int[2];
        
        while (lo <= hi){
            int sum = numbers[lo] + numbers[hi];
            if (sum == target){
                sol[0] = lo+1;
                sol[1] = hi+1;
                
                return sol;
            }
            else if(sum > target)
                hi--;
            else
                lo++;
        
        }
        return sol;
    }
}