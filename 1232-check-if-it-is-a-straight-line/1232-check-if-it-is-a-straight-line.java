class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        if (n == 2)
            return true;
        int x0 = coordinates[0][0], x1 = coordinates[1][0];
        int y0 = coordinates[0][1], y1 = coordinates[1][1];
        int dx = x1 - x0;
        int dy = y1 - y0;
        
        for (int i = 2; i < n; i++){
            if (dx*(coordinates[i][1] - y1) != dy*(coordinates[i][0] - x1))
                return false;
        }
        return true;
    }
}