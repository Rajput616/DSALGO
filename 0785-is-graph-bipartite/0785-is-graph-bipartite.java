class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for(int i = 0; i < n; ++i){
            if(color[i] == 0 && checkOddCycle(i, graph, color)) return false;
        }
        return true;
    }
    
    private boolean checkOddCycle(int i, int[][] graph, int[] color){
        Queue<Integer> q = new LinkedList();
        q.offer(i);
        color[i] = 1;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int neigh : graph[node]){
                if(color[neigh] == 0){
                    color[neigh] = color[node] == 1 ? 2 : 1;
                    q.offer(neigh);
                } else if(color[neigh] == color[node]) return true;
            }
        }
        return false;
    }
}

// class Solution {
//     public boolean isBipartite(int[][] graph) {
//         int n = graph.length;
//         int[] color = new int[n];
//         for(int i = 0; i < n; ++i){
//             if(checkOddCycle(i, graph, color)) return false;
//         }
//         return true;
//     }
//     private boolean checkOddCycle(int node, int[][] graph, int[] color){
//         if(color[node] == 0) color[node] = 1;
//         for(int neigh : graph[node]){
//             if(color[neigh] == 0){
//                 color[neigh] = color[node] == 1 ? 2: 1;
//                 if(checkOddCycle(neigh, graph, color)) return true;
//             } else if(color[neigh] == color[node]){
//                 return true;
//             }
//         }
//         return false;
//     }
// }