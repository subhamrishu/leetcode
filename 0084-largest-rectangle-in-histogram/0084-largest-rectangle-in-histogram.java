class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0, n = heights.length;
        
        for(int i = 0; i <=n; i++){
            int currHeight = (i == n)? 0: heights[i];
            while (!stack.empty() && currHeight < heights[stack.peek()]){
                int top = stack.pop();
                int left = stack.empty() ? -1 : stack.peek();
                int right = i;
                int area = heights[top] * (right - left - 1);
                maxArea = Math.max(maxArea, area);
                // if(i != n)
                // System.out.println(area+" "+maxArea+" i = "+heights[i]+" left= "+left+" right="+right + " "+stack);
            }
            stack.push(i);
        }
        return maxArea;
    }
}