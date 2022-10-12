//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    static int countPaths(int n, List<List<Integer>> roads) {
        //Adj List
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; ++i) adj.add(new ArrayList<>());
        for(List<Integer> road : roads){
            int u = road.get(0);
            int v = road.get(1);
            int dist = road.get(2);
            adj.get(u).add(new int[]{v, dist});
            adj.get(v).add(new int[]{u, dist});
        }
        int mod = (int)1e9 + 7;
        //Djiktras
        int[] dist = new int[n];
        int[] ways = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        while(!pq.isEmpty()){
            int[] front = pq.poll();
            int node = front[0];
            int prevDist = front[1];
            for(int[] neigh : adj.get(front[0])){
                int neigh_node = neigh[0];
                int neigh_dist = neigh[1];
                if(prevDist + neigh_dist < dist[neigh_node]){
                    dist[neigh_node] = prevDist + neigh_dist;
                    ways[neigh_node] = ways[node];
                    ways[neigh_node] %= mod;
                    pq.offer(new int[]{neigh_node, dist[neigh_node]});
                } else if(prevDist + neigh_dist == dist[neigh_node]){
                    ways[neigh_node] += ways[node];
                    ways[neigh_node] %= mod;
                }
            }
        }
        return ways[n-1];
    }
}
