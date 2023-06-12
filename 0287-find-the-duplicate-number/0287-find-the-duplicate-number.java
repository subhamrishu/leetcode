class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++){
            if (visited[nums[i]-1])
                return nums[i];
            visited[nums[i]-1] = true;
        }
        return nums[0];
    }
}