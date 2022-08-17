class Solution {
    public int longestConsecutive(int[] nums) {
        /* Using ----------HashMap------------------
        HashMap<Integer, Boolean> map = new HashMap();
        int max = 0;
        for(int i = 0; i<nums.length; i++){
            // if (map.containsKey(nums[i]-1))
            //     map.put(nums[i], map.get(nums[i]-1)+1);
            // else
            //     map.put(nums[i], 1);
            // int curr = map.get(nums[i]);
            // max = Math.max(max, curr);
            if (!map.containsKey(nums[i]))
                map.put(nums[i], false);
        }
        int i = 0;
        while (i < nums.length){
            int curr = nums[i];
            int local_max = 1;
            while (map.containsKey(curr-1) && !map.get(curr-1)){
                local_max += 1;
                map.put(curr, true);
                curr -= 1;
            }
            curr = nums[i];
            while (map.containsKey(curr+1) && !map.get(curr+1)){
                local_max += 1;
                map.put(curr, true);
                curr += 1;
            }
            max = Math.max(max, local_max);
            i++;
        }
        // System.out.println(map);
        return max;
        */
        /* Using --------------HashSet--------------- */
        if (nums == null || nums.length == 0)
            return 0;
        Set<Integer> set = new HashSet();
        for (int num: nums) 
            set.add(num);
        int longestSeq = 0;
        
        for (int num: nums){
            int left = num-1;
            int right = num + 1;
            while (set.remove(left)) left--;
            while(set.remove(right)) right++;
            longestSeq = Math.max(longestSeq, right-left-1);
            if (set.isEmpty()) return longestSeq;
        }
        return longestSeq;
    }
}