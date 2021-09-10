class Solution {
   public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
​
        if (grid.length == 0) return perimeter;
​
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += getPerimeter(grid, i - 1, j);
                    perimeter += getPerimeter(grid, i + 1, j);
                    perimeter += getPerimeter(grid, i, j - 1);
                    perimeter += getPerimeter(grid, i, j + 1);
                }
            }
        }
        return perimeter;
    }
​
    private int getPerimeter(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length) return 1;
​
        if (grid[row][col] == 0) return 1;
​
        return 0;
    }
}
