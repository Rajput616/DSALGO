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
            int[][] arr = new int[n][2];
            for(int i=0;i<n;i++){
                arr[i][0]=sc.nextInt();
                arr[i][1]=sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.maxRemove(arr,n);
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
        for(int i = 0; i < n; ++i)
            parent[i] = i;
    }
    
    public int findPar(int u){
        if(parent[u] == u) return u;
        return parent[u] = findPar(parent[u]);
    }
    public void union(int u, int v){
        int ultU = findPar(u);
        int ultV = findPar(v);
        if(ultU == ultV) return;
        
        if(rank[ultU] < rank[ultV]){
            parent[ultU] = ultV;
            rank[ultV]++;
        } else{
            parent[ultV] = ultU;
            rank[ultU]++;
        }
    }
    
}

class Solution {

    int maxRemove(int[][] stones,int n) {
        int maxRow = 0, maxCol = 0;
        for(int[] stone : stones){
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }
        maxRow++;
        maxCol++;
        Set<Integer> set = new HashSet();
        DSU dsu = new DSU(maxRow + maxCol + 1);
        for(int[] stone : stones){
            int r = stone[0];
            int c = stone[1] + maxRow + 1;
            dsu.union(r, c);
            set.add(r);
            set.add(c);
        }
        int stoneCount = 0;
        for(int val : set){
            if(dsu.findPar(val) == val) stoneCount++;
        }
        return n - stoneCount;
    }
};
