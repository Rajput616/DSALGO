class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> prev = new ArrayList();
        for(int i = 0; i < numRows; ++i){
            List<Integer> curr = new ArrayList(prev);
            for(int j = 1; j < i; ++j){
                curr.set(j, prev.get(j-1) + prev.get(j));
            }
            curr.add(1);
            prev = curr;
            ans.add(curr);
        }
        return ans;
    }
}