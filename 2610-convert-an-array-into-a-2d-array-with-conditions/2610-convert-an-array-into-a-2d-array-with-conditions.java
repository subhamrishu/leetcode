class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] freq = new int[201];
        int max = 0;
        for (int num: nums){
            max = Math.max(max, num);
            freq[num]++;
        }
        List<List<Integer>> sol = new ArrayList<>();
        
        while (true){
            boolean flag = true;
            List<Integer> temp = new ArrayList<>();
            for (int i = 1; i <= max; i++){
                if (freq[i] > 0){
                    temp.add(i);
                    freq[i]--;
                    flag = false;
                }
            }
            if (flag)
                break;
            sol.add(temp);
        }
        return sol;
    }
}