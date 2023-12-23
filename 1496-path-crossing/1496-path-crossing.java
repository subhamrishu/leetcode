class Solution {
    class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        int x = 0 , y = 0;
        set.add("0" + ",0");
        
        for (char ch : path.toCharArray()){
            if (ch == 'N'){
                y += 1;
            }else if (ch == 'S'){
                y -= 1;
            }else if(ch == 'E'){
                x += 1;
            }else if(ch == 'W'){
                x -= 1;
            }
            
            // Point p = new Point(x, y);
            int[] p = new int[]{x, y};
            String s = x + ","+y;
            if (set.contains(s)){
                return true;
            }else{
                set.add(s);
            }
            
            // System.out.println("x = "+x+" y= "+y+ " point = "+p);
        }
        return false;
    }
}