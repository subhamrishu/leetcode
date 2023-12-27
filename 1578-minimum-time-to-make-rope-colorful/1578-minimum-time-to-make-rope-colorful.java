class Solution {
    public int minCost(String colors, int[] neededTime) {
        int total = 0, currMaxTime= 0;
        for (int i = 0; i < colors.length(); i++){
            // int j = i, maxLocal = neededTime[i-1], sum = neededTime[i-1];
            
//             while (j < colors.length() && colors.charAt(j) == colors.charAt(j-1)){
//                 maxLocal = Math.max(maxLocal, neededTime[j]);
//                 sum += neededTime[j];
//                 j++;
                
//             }
//             // System.out.println("i = "+ i+" j = "+j+" sum = "+ sum+ " minLocal = "+ maxLocal);
//             if (j != i){
//                 minT += (sum - maxLocal);
//                 i = j;
//             }
            
            if (i > 0 && colors.charAt(i) != colors.charAt(i-1)){
                currMaxTime = 0;
            }
            total += Math.min(currMaxTime, neededTime[i]);
            currMaxTime = Math.max(currMaxTime, neededTime[i]);
        }
        return total;
    }
}