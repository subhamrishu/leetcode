class Solution {
    int perimeter;
    int side;
    // Boolean dp[];
    boolean allSidesEqual(int[] sides){
        return sides[0] == side && sides[1] == side && sides[2] == side;
    }
    boolean sidesInvalid(int[] sides){
        // if (a > side || b > side || c > side || d > side)
        //     return true;
        // return false;
        return sides[0] > side || sides[1] > side || sides[2] > side || sides[3] > side; 
    }
//     boolean helper(int sideA, int sideB, int sideC, int sideD, int curr, int[] matchsticks){
        
//         // int currPerimeter = sideA + sideB + sideC +  sideD;
//         if (sidesInvalid(sideA, sideB, sideC, sideD))
//             return false;
//         if (curr == matchsticks.length)
//            return allSidesEqual(sideA, sideB, sideC, sideD);
// //         if (dp[curr] != null)
// //             return dp[curr];
        
//         return helper(sideA+matchsticks[curr], sideB, sideC, sideD, curr+1, matchsticks) || helper(sideA, sideB+matchsticks[curr], sideC, sideD, curr+1, matchsticks) || helper(sideA, sideB, sideC+matchsticks[curr], sideD, curr+1, matchsticks) || helper(sideA, sideB, sideC, sideD+matchsticks[curr], curr+1, matchsticks);
        
            
//     }
    boolean helper(int[] sides, int[] matchsticks, int curr){
        // if (sidesInvalid(sides))
        //     return false;
        if (curr == matchsticks.length)
            return allSidesEqual(sides);
        for(int i = 0; i < 4; i++){
            if (sides[i] + matchsticks[curr] > side) continue;
            sides[i] += matchsticks[curr];
            if(helper(sides, matchsticks, curr+1)) return true;
            sides[i] -= matchsticks[curr];
        }
        return false;
    }
    public boolean makesquare(int[] matchsticks) {
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        // Arrays.stream(matchsticks).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        perimeter=0;
        // dp = new Boolean[matchsticks.length];
        for(int stick: matchsticks){
            perimeter += stick;
        }
        side = (int)perimeter/4;
        if (side * 4 != perimeter)
            return false;
        boolean res =  helper(new int[4], matchsticks, 0);
        // System.out.println(Arrays.toString(dp));
        return res;
    }
    void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++; j--;
        }
    }
}