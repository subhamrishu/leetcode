class Solution {
    boolean checkArithmetic(List<Integer> l){
        int d = l.get(1) - l.get(0);
        for (int i = 1; i < l.size()-1; i++){
            if (l.get(i+1) - l.get(i) != d)
                return false;
        }
        return true;
    }
    boolean checkArithmetic2(int[] nums, int start, int end){
        int n = end - start;
        if (n <= 1)
            return true;
        Set<Integer> set = new HashSet<>();
        int min = nums[start], max = nums[start];
        for (int k = start; k <= end; k++){
            min = Math.min(min, nums[k]);
            max = Math.max(max, nums[k]);
            set.add(nums[k]);
        }
        if (((max - min) % n) != 0)
            return false;
        int interval = (max - min )/ n;
        
        for (int k = 1; k <= n; k++){
            if(!set.contains(min + k * interval))
                return false;
        }
        return true;
    }
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> sol = new ArrayList<>();
        for (int i = 0; i < l.length; i++){
            sol.add(checkArithmetic2(nums, l[i], r[i]));
        }
        return sol;
    }
}