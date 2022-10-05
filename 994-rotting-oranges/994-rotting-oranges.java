class Solution {
    
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int freshCount = 0;
        Queue<int[]> q = new LinkedList();
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(grid[i][j] == 2) q.offer(new int[]{i, j});
                else if(grid[i][j] == 1) freshCount++;
            }
        }
        if(freshCount == 0) return 0;
        int mins = -1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] pos = q.poll();
                for(int[] dir : dirs){
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    
                    if(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] != 1) continue;
                    q.offer(new int[]{x, y});
                    freshCount--;
                    grid[x][y] = 2;
                }
            }
            mins++;
        }
        return freshCount == 0 ? mins : -1;
    }
}