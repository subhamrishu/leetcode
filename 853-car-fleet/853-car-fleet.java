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
        Stack<Double> stack = new Stack();
        stack.add(getRemainingTime(target, l.get(0).position, l.get(0).speed));
        for (int i = 1; i < n; i++){
            double time = getRemainingTime(target, l.get(i).position, l.get(i).speed);
            // System.out.println(l.get(0).position +" "+time+" "+sol);
            if (!stack.empty() && stack.peek() < time){
                sol++;
                stack.push(time);
            }
        }
        // for (Pair p : l){
        //     // double time = (target - p.position)* 1/(double)p.speed;
        //     // System.out.println(p.position +" "+time);
        //      getRemainingTime(target, )
        //     if (!stack.empty() && stack.peek() < time){
        //         sol++;
        //         stack.push(time);
        //         continue;
        //     }
        //     stack.push(time);
        //     // sol++;
        // }
        return sol;
    }
}