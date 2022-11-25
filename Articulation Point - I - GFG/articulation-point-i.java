//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    int timer = 1;
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        // int[] vis = new int[V];
        boolean[] vis = new boolean[V];
        int[] tin = new int[V];
        int[] low = new int[V];
        // int[] mark = new int[V];
        boolean[] mark = new boolean[V];
        for(int i = 0; i < V; ++i){
            if(!vis[i]){
                dfs(i, -1, vis, tin, low, mark, adj);
            }
        }
        ArrayList<Integer> ans = new ArrayList();
        for(int i = 0; i < V; ++i){
            if(mark[i]) ans.add(i);
        }
        if(ans.size() == 0) ans.add(-1); 
        return ans;
    }
    
    private void dfs(int node, int parent, boolean[] vis, int[] tin, int[] low, boolean[] mark, ArrayList<ArrayList<Integer>> adj){
        vis[node]  = true;
        low[node] = tin[node] = timer;
        timer++;
        int child = 0;
        for(int neigh : adj.get(node)){
            if(neigh == parent) continue;
            
            if(!vis[neigh]){
                dfs(neigh, node, vis, tin, low, mark, adj);
                low[node] = Math.min(low[node], low[neigh]);
                if(low[neigh] >= tin[node] && parent != -1){
                    mark[node] = true;
                }
                child++;
            } else{
                low[node] = Math.min(low[node], tin[neigh]);
            }
        }
        if(child > 1 && parent == -1) mark[node] = true;
    }
}