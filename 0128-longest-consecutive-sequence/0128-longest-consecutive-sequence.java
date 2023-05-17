class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums){
            set.add(num);
        }
        int max = 0;
        for (int num: nums){
            int count = 1;
            if (!set.contains(num-1)){
                int copy = num+1;
                while (set.contains(copy)){
                    count++;
                    // set.remove(copy);
                    copy++;
                }
                // copy = num+1;
                // while(set.contains(copy)){
                //     count++;
                //     set.remove(copy);
                //     copy++;
                // }
                max = max < count ? count : max;
            }
        }
        return max;
    }
}