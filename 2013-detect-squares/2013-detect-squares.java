class DetectSquares {
    int[][] pointCount;
    List<int[]> points;
    
    public DetectSquares() {
        pointCount = new int[1001][1001];
        points = new ArrayList<>();
    }
    
    public void add(int[] point) {
        pointCount[point[0]][point[1]] += 1;
        points.add(point);
    }
    
    public int count(int[] point) {
        int x1 = point[0], y1 = point[1], ans = 0;
        for (int[] p3: points){ //diagnol point
            int x3 = p3[0], y3 = p3[1];
            if (Math.abs(x1-x3) == 0 || Math.abs(x1-x3) != Math.abs(y1-y3))
                continue; //skip square with size 0 or with unequal lengths
            ans += pointCount[x1][y3] * pointCount[x3][y1];
        }
        return ans;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */