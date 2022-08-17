class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for (int num: nums){
            set.add(num);
        }
        int max = 0;
        for (int num: nums){
            int localMax=1, ele=num-1;
            while(set.remove(ele--)) localMax++;
            ele = num+1;
            while(set.remove(ele++)) localMax++;
            max = Math.max(max, localMax);
            if(set.isEmpty()) return max;

        }
        return max;
    }
}