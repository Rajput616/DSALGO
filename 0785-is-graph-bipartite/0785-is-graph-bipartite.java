class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for(int i = 0; i < n; ++i){
            if(checkBipartite(i, graph, color)) return false;
        }
        return true;
    }
    private boolean checkBipartite(int node, int[][] graph, int[] color){
        if(color[node] == 0) color[node] = 1;
        for(int neigh : graph[node]){
            if(color[neigh] == 0){
                color[neigh] = color[node] == 1 ? 2: 1;
                if(checkBipartite(neigh, graph, color)) return true;
            } else if(color[neigh] == color[node]){
                return true;
            }
        }
        return false;
    }
}