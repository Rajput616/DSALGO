class Solution {
    public int[][] merge(int[][] inter) {
        int n = inter.length;
        if(n == 1) return inter;
        
        Arrays.sort(inter, (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] prev = inter[0];
        
        List<int[]> ans = new ArrayList();
        for(int i = 1; i < n; ++i){
            if(prev[1] >= inter[i][0]){
                prev[1] = Math.max(prev[1], inter[i][1]);
            } else{
                ans.add(prev);
                prev = inter[i];
            }
        }
        ans.add(prev);
        
        int[][] ansArr = new int[ans.size()][2];
        int index = 0;
        for(int[] it : ans) ansArr[index++] = it;
        return ansArr;
    }
}