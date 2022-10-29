//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class DSU{
    int[] parent, rank;
    DSU(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; ++i) parent[i] = i;
    }
    
    public int findPar(int node){
        if(node == parent[node]) return node;
        return parent[node] = findPar(parent[node]);
    }
    
    public boolean unionByRank(int u, int v){
        int ultU = findPar(u);
        int ultV = findPar(v);
        
        if(ultU == ultV) return false;
        if(rank[ultU] < rank[ultV]){
            parent[ultU] = ultV;
        } else{
            parent[ultV] = ultU;
            rank[ultV]++;
        }
        
        return true;
    }
    
}

class Solution
{
    
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        List<int[]> edges = new ArrayList();
        for(int i = 0; i < V; ++i){
            int node = i;
            for(ArrayList<Integer> neigh : adj.get(i)){
                edges.add(new int[]{node, neigh.get(0), neigh.get(1)});
            }
        }
        Collections.sort(edges, (a,b) -> a[2] - b[2]);
        int mst = 0;
        DSU dsu = new DSU(V);
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            if(dsu.unionByRank(u, v)) mst += edge[2];
        }
        return mst;
    }
}
