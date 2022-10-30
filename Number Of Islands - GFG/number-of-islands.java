//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class DSU{
    int[] parent, rank;
    DSU(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; ++i) parent[i] = i;
    }
    public int find(int u){
        if(parent[u] == u) return u;
        return parent[u] = find(parent[u]);
    }
    
    public void union(int u, int v){
        int ultU = find(u);
        int ultV = find(v);
        if(ultU == ultV) return;
        
        if(rank[ultU] < rank[ultV]) parent[ultU] = ultV;
        else {
            parent[ultV] = ultU;
            rank[ultU]++;
        }
    }
}
class Solution {
    
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        DSU dsu = new DSU(rows*cols);
        boolean[][] vis = new boolean[rows][cols];
        int islands = 0;
        List<Integer> ans = new ArrayList();
        for(int[] op : operators){
            int i = op[0], j = op[1];
            if(vis[i][j]) {
                ans.add(islands);
                continue;
            }
            vis[i][j] = true;
            islands++;
            int code1 = i*cols + j;
            for(int[] d : dirs){
                int x = i + d[0];
                int y = j + d[1];
                
                if(x < 0 || x >= rows || y < 0 || y >= cols || !vis[x][y]) continue;
                int code2 = x*cols + y;
                if(dsu.find(code1) != dsu.find(code2)){
                    islands--;
                    dsu.union(code1, code2);
                }
            }
            ans.add(islands);
        }
        return ans;
    }
    
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends