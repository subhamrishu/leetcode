class Solution {
    class Pair{
        int position, speed;
        Pair(int position, int speed){
            this.position = position;
            this.speed = speed;
        }
    }
    double getRemainingTime(int target, int position, int speed){
        return (target - position)* 1/(double)speed;
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 1)
            return 1;
        
        List<Pair> l = new ArrayList();
        for (int i = 0; i< n; i++){
            l.add(new Pair(position[i], speed[i]));
        }
        Collections.sort(l, (a,b) -> b.position - a.position);
        
        int sol = 1;
        double[] stack = new double[n];
        int top = -1;
        for (int i = 0; i < n; i++){
            double time = getRemainingTime(target, 
                                           l.get(i).position, 
                                           l.get(i).speed);
            if (top == -1){
                stack[++top] = time;
            }
            if (stack[top] < time){
                sol++;
                stack[++top] = time;
            }
        }
        return sol;
    }
}