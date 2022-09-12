class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        swapColumns(matrix);
    }
    private void transpose(int[][] matrix){
        int n = matrix.length;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < i; ++j){
                swap(matrix, i, j, j, i);
            }
        }
    }
    
    private void swapColumns(int[][] matrix){
        int n = matrix.length;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n/2; ++j){
                swap(matrix, i, j, i, n-j-1);
            }
        }
    }
    
    private void swap(int[][] matrix, int i, int j, int k, int l){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[k][l];
        matrix[k][l] = temp;
    }
}