class Solution {
int max;
void dfs(int[][] grid, int[][] time, boolean[][] visited, int i, int j, int currTime){
if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j])
return;
visited[i][j] = true;
time[i][j] = Math.min(time[i][j], currTime+1);
// max = Math.max(max, time[i][j]);
// System.out.println(time[i][j]+ " "+i + " "+j);
if (i+1 < grid.length && grid[i+1][j] == 1)
dfs(grid, time, visited, i+1, j, currTime+1);
if (i-1 >= 0 && grid[i-1][j] == 1)
dfs(grid, time, visited, i-1, j, currTime+1);
if (j+1 < grid[0].length && grid[i][j+1] == 1)
dfs(grid, time, visited, i, j+1, currTime+1);
if (j-1 >= 0 && grid[i][j-1] == 1)
dfs(grid, time, visited, i, j-1, currTime+1);
}
public int orangesRotting(int[][] grid) {
int m = grid.length, n = grid[0].length;
int[][] time = new int[m][n];
max = Integer.MIN_VALUE;
for (int[] row: time){
Arrays.fill(row, 101);