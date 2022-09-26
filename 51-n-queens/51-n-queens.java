class Solution {
    boolean[] diag1, diag2, col;
    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        diag1 = new boolean[2*n-1];
        diag2 = new boolean[2*n-1];
        List<List<String>> ans = new ArrayList();
        solve(0, n, new ArrayList(), ans);    
        return ans;
    }
    
    private void solve(int row, int n, List<String> curr, List<List<String>> ans){
        if(row == n){
            ans.add(new ArrayList(curr));
            return;
        }
        
        for(int r = row, c = 0; c < n; ++c){
            if(col[c] || diag1[r+c] || diag2[(n-1) + (r-c)]) continue;
            
            col[c] = true;
            diag1[r+c] = true;
            diag2[(n-1) + (r-c)] = true;
            char[] chArr = new char[n];
            Arrays.fill(chArr, '.');
            chArr[c] = 'Q';
            String str = new String(chArr);
            curr.add(str);
            
            solve(row+1, n, curr, ans);
            
            curr.remove(curr.size()-1);
            col[c] = false;
            diag1[r+c] = false;
            diag2[(n-1) + (r-c)] = false;
        }
        
    }
    
    
}