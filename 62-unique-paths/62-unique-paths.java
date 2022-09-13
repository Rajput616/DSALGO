class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        Arrays.fill(prev, 1);
        for(int i = 1; i < m; ++i){
            int[] curr = new int[n];
            curr[0] = 1;
            for(int j = 1; j < n; ++j){
                curr[j] = prev[j] + curr[j-1];
            }
            prev = curr;
        }
        return prev[n-1];
    }
}