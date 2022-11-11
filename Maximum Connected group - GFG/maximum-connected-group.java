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
            int[][] grid = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            
            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class DSU{
    int[] parent, size;
    DSU(int n){
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; ++i) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public int findPar(int u){
        if(parent[u] == u) return u;
        return parent[u] = findPar(parent[u]);
    }
    public void union(int u, int v){
        int ultU = findPar(u);
        int ultV = findPar(v);
        if(ultU == ultV) return;
        
        if(size[ultU] < size[ultV]){
            parent[ultU] = ultV;
            size[ultV] += size[ultU];
        } else{
            parent[ultV] = ultU;
            size[ultU] += size[ultV];
        }
    }
}

class Solution {
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int MaxConnection(int grid[][]) {
        int n = grid.length;
        DSU dsu = new DSU(n*n);
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if(grid[i][j] == 1){
                    int code1 = i*n + j;
                    for(int[] dir : dirs){
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if(x < 0 || x >= n || y < 0 || y >= n || grid[x][y] != 1) continue;
                        int code2 = x*n + y;
                        dsu.union(code1, code2);
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(dsu.size));
        int maxSize = 0;
        
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                int code = i*n + j;
                int parC = dsu.findPar(code);
                maxSize = Math.max(maxSize, dsu.size[parC]);
                if(grid[i][j] == 0){
                    Set<Integer> set = new HashSet();
                    int curSize = 1;
                    for(int[] dir : dirs){
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if(x < 0 || x >= n || y < 0 || y >= n || grid[x][y] != 1) continue;
                        int code2 = x*n + y;
                        int par = dsu.findPar(code2);
                        if(set.add(par))
                            curSize += dsu.size[par];
                    }
                    maxSize = Math.max(maxSize, curSize);
                }
            }
        }
        return maxSize;
    }
    
}