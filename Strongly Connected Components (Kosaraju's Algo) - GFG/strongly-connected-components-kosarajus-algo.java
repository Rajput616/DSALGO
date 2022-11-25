//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; ++i){
            if(!vis[i]){
                dfs(i, adj, vis, st);
            }
        }
        // dfs(0, adj, new boolean[V], st);
        adj = reverseGraph(V, adj);
        int scc = 0;
        vis = new boolean[V];
        while(!st.isEmpty()){
            int node = st.pop();
            if(!vis[node]){
                dfs(node, adj, vis, null);
                scc++;
            }
        }
        return scc;
    }
    
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> st){
        vis[node] = true;
        for(int neigh : adj.get(node)){
            if(!vis[neigh])
                dfs(neigh, adj, vis, st);
        }
        if(st != null) 
            st.push(node);
    }
    
    private ArrayList<ArrayList<Integer>> reverseGraph(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<ArrayList<Integer>> graph = new ArrayList();
        for(int i = 0; i < V; ++i) graph.add(new ArrayList());
        for(int i = 0; i < V; ++i){
            for(int neigh : adj.get(i)){
                graph.get(neigh).add(i);
            }
        }
        
        return graph;
    }
}
