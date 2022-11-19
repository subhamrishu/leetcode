class Solution {
    boolean checkArithmetic(List<Integer> l){
        int d = l.get(1) - l.get(0);
        for (int i = 1; i < l.size()-1; i++){
            if (l.get(i+1) - l.get(i) != d)
                return false;
        }
        return true;
    }
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> sol = new ArrayList<>();
        for (int i = 0; i < l.length; i++){
            List<Integer> temp = new ArrayList<>();
            if (r[i] - l[i] < 1){
                sol.add(false);
                continue;
            }
            for (int k = l[i]; k <= r[i]; k++){
                temp.add(nums[k]);
            }
            Collections.sort(temp);
            if(checkArithmetic(temp))
                sol.add(true);
            else
                sol.add(false);
        }
        return sol;
    }
}