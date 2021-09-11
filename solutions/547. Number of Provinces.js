/**
 * @param {number[][]} M
 * @return {number}
 */
var findCircleNum = function(matrix) {
    let visited = [];
    let circles = 0;
    
    // all row && col -> matrix.length is visited as well as and friends
    // that are from matrix.length -> matrix.length if any of the elements are 1
    const dfs = (row, matrix, visited) => {       
        for(let col = 0; col < matrix[row].length; col++) {
            // Remember to check the number is a one
            if(!visited[col] && matrix[row][col] === 1) {
                visited[col] = true;
                dfs(col, matrix, visited);
            }
        }
    }
    
    for(let row = 0; row < matrix.length; row++) {
        // visited[row] and visited[col] and added through DFS as friends
        if(!visited[row]) {
            dfs(row, matrix, visited);
            circles++;
        }
    }
    
    return circles;
};
