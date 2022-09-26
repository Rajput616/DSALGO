class Solution {
    public void solveSudoku(char[][] board) {
        int n = board.length;
        solve(n, board);
    }
    private boolean solve(int n, char[][] board){
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if(board[i][j] == '.'){
                    for(char k = '1'; k <= '9'; ++k){
                        if(isPossible(i, j, n, board, k)){
                            board[i][j] = k;
                            if(solve(n, board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }    
        }
        return true;
    }
    private boolean isPossible(int r, int c, int n, char[][] board, char ch){
        for(int i = 0; i < n; ++i){
            if(board[i][c] == ch) return false;
            if(board[r][i] == ch) return false;
        }
        
        r = r / 3 * 3;
        c = c / 3 * 3;
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[r+i][c+j] == ch) return false;
            }
        }
        return true;
    }
}