//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            
            Solution obj = new Solution();
            int ans = obj.Solve(n,edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class DSU{
    int[] parent, rank;
    DSU(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; ++i) parent[i] = i;
    }
    
    public int findPar(int u){
        if(u == parent[u]) return u;
        return parent[u] = findPar(parent[u]);
    }
    
    public void union(int u, int v){
        int ultU = findPar(u);
        int ultV = findPar(v);
        if(ultU == ultV) return;
        
        if(rank[ultU] < rank[ultV]){
            parent[ultU] = ultV;
        } else{
            parent[ultV] = ultU;
            rank[ultU]++;
        }
    }
}

class Solution {
    
    public int Solve(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int extraEdges = 0;
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            if(dsu.findPar(u) != dsu.findPar(v)){
                dsu.union(u, v);
            } else extraEdges++;
        }
        int minEdgesReq = -1; 
        for(int i = 0; i < n; ++i){
            if(dsu.findPar(i) == i) minEdgesReq++;
        }
        return extraEdges >= minEdgesReq ? minEdgesReq : -1;
    }
}