class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int n  = asteroids.length;
        for (int i = 0; i < n; i++){
            // if (stack.isEmpty()){
            //     stack.push(asteroid);
            //     continue;
            // }
            while (!stack.isEmpty() && stack.peek() > 0 && i < n && asteroids[i] < 0){
                if (stack.peek() == Math.abs(asteroids[i])){
                    stack.pop();
                    i++;
                }
                else if (stack.peek() < Math.abs(asteroids[i]))
                    stack.pop();
                else 
                    i++;
                
            }
            if (i < n)
                stack.push(asteroids[i]);
        }
        int[] sol = new int[stack.size()];
        int k = 0;
        for (int num: stack){
            sol[k++] = num;
        }
        return sol;
    }
}