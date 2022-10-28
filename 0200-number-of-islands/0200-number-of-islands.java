class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int countIsland = 0;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(grid[i][j] == '1'){
                    markAllVis(i, j, grid);
                    countIsland++;
                }
            }
        }
        return countIsland;
    }
    
    private void markAllVis(int i, int j, char[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
        
        grid[i][j] = '0';
        markAllVis(i-1, j, grid);
        markAllVis(i, j+1, grid);
        markAllVis(i+1, j, grid);
        markAllVis(i, j-1, grid);
    }
}

// class Solution {
//     public int numIslands(char[][] grid) {
//         int n = grid.length, m = grid[0].length;
//         int countIsland = 0;
//         boolean[][] vis = new boolean[n][m];
//         for(int i = 0; i < n; ++i){
//             for(int j = 0; j < m; ++j){
//                 if(grid[i][j] == '1' && !vis[i][j]){
//                     markAllVis(i, j, grid, vis);
//                     countIsland++;
//                 }
//             }
//         }
//         return countIsland;
//     }
    
//     private void markAllVis(int i, int j, char[][] grid, boolean[][] vis){
//         if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || vis[i][j] || grid[i][j] == '0') return;
        
//         vis[i][j] = true;
//         markAllVis(i-1, j, grid, vis);
//         markAllVis(i, j+1, grid, vis);
//         markAllVis(i+1, j, grid, vis);
//         markAllVis(i, j-1, grid, vis);
//     }
// }