class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i< nums.length-2; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0){
                    sol.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    // System.out.println(i+" "+j+" "+k);
                    j++; k--;
                    while (j < k && nums[j] == nums[j-1])
                    j++;
                while (j < k && nums[k] == nums[k+1])
                    k--;
                }
                else if (sum > 0)
                    k--;
                else if(sum < 0)
                    j++;
            }
            while (i < nums.length-1 && nums[i] == nums[i+1])
                i++;
        }
        return sol;
    }
}