class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;//maintain count of components
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    drawTreeandGetComponents(grid,i,j,visited);
                    count++;
                }  
            }
        }
        return count;
        
    }
    
    public void drawTreeandGetComponents(char[][] arr, int i, int j, boolean[][] visited){
        // check if it's on board + check if it's actually land or water + check if the vertex is visited or not
        if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == '0' || visited[i][j] == true){
            return;
        }
        
        
        visited[i][j] = true;
        drawTreeandGetComponents(arr, i-1, j, visited);
        drawTreeandGetComponents(arr, i, j+1, visited);
        drawTreeandGetComponents(arr, i+1, j, visited);
        drawTreeandGetComponents(arr, i, j-1, visited);
    }
}
