class Solution {
    public int minCost(String colors, int[] neededTime) {
        int minT = 0;
        for (int i = 1; i < colors.length(); i++){
            int j = i, maxLocal = neededTime[i-1], sum = neededTime[i-1];
            
            while (j < colors.length() && colors.charAt(j) == colors.charAt(j-1)){
                maxLocal = Math.max(maxLocal, neededTime[j]);
                sum += neededTime[j];
                j++;
                
            }
            // System.out.println("i = "+ i+" j = "+j+" sum = "+ sum+ " minLocal = "+ maxLocal);
            if (j != i){
                minT += (sum - maxLocal);
                i = j;
            }
        }
        return minT;
    }
}