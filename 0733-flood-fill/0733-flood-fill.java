class Solution {
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        int m = image.length, n = image[0].length;
        Queue<int[]> q = new LinkedList();
        q.offer(new int[]{sr, sc});
        int pixel = image[sr][sc];
        image[sr][sc] = color;
        while(!q.isEmpty()){
            int[] front = q.poll();
            for(int[] dir : dirs){
                int x = front[0] + dir[0];
                int y = front[1] + dir[1];
                
                if(x < 0 || y < 0 || x >= m || y >= n || image[x][y] != pixel) continue;
                
                image[x][y] = color;
                q.offer(new int[]{x, y});
            }
        }
        return image;
    }
}