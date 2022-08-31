class Solution {
    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList();
        if(heights == null || heights.length == 0 || heights[0].length == 0) return res;
        
        int row = heights.length;
        int col = heights[0].length;
        
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        
        //DFS
        for(int i = 0; i < row; ++i){
            dfs(i, 0, -1, heights, pacific);
            dfs(i, col-1, -1, heights, atlantic);
        }
        for(int i = 0; i < col; ++i){
            dfs(0, i, -1, heights, pacific);
            dfs(row-1, i, -1, heights, atlantic);
        }
        
        for(int i = 0; i < row; ++i){
            for(int j = 0; j < col; ++j){
                if(pacific[i][j] && atlantic[i][j]) res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }
    private void dfs(int i, int j, int prev, int[][] mat, boolean[][] vis){
        if(i < 0 || j < 0 || i >= mat.length || j >= mat[0].length) return;
        if(mat[i][j] < prev || vis[i][j]) return;
        vis[i][j] = true;
        for(int[] d : dir){
            dfs(i+d[0], j+d[1], mat[i][j], mat, vis);
        }
    }
}