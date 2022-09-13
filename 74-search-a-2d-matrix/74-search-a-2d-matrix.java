class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[m-1][n-1]) return false;
        
        int row = 0;
        for(; row < m; ++row){
            if(matrix[row][0] > target){
                break;
            }
        }
        row--;
        
        for(int col = 0; col < n; ++col){
            if(matrix[row][col] == target) return true;
        }
        
        return false;
    }
}