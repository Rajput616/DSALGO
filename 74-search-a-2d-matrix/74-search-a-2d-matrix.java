class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[m-1][n-1]) return false;
        
        int low = 0, high = m-1;
        while(low <= high){
            int mid = (low + high) >> 1;
            
            if(matrix[mid][0] == target) return true;
            else if(matrix[mid][0] > target) high = mid-1;
            else low = mid+1;
        }
        
        int row = high;
        low = 0; high = n-1;
        while(low <= high){
            int mid = (low + high) >> 1;
            
            if(matrix[row][mid] == target) return true;
            else if(matrix[row][mid] > target) high = mid-1;
            else low = mid+1;
        }
        
        return false;
    }
}