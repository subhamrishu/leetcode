class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, top = -1;
        int stack[] = new int[n];
        int sol = 0, height= 0 , length=0;
        for (int i = 0; i < n; i++){
            while (top != -1 && heights[stack[top]] > heights[i]){
                height = heights[stack[top--]];
                if (top != -1)
                    length = i - stack[top] - 1;
                else
                    length = i;
                sol = Math.max(sol, height*length);
                // System.out.println(i+" "+sol);
            }
            stack[++top] = i;
        }
        // stack[++top] = n;
        
        while (top != -1 && heights[stack[top]] > 0){
            height = heights[stack[top--]];
            if (top != -1)
                length = n - stack[top] - 1;
            else
                length = n;
            sol = Math.max(sol, height*length);
        }
        return sol;
    }
}