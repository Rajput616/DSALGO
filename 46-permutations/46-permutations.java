class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        allPerm(0, nums, ans, new ArrayList(), new boolean[nums.length]);
        return ans;
    }
    private void allPerm(int count, int[] nums, List<List<Integer>> ans, List<Integer> curr, boolean[] vis){
        if(count == nums.length){
            ans.add(new ArrayList(curr));
            return;
        }
        
        for(int j = 0; j < nums.length; ++j){
            if(!vis[j]){
                vis[j] = true;
                curr.add(nums[j]);
                allPerm(count + 1, nums, ans, curr, vis);
                curr.remove(curr.size()-1);
                vis[j] = false;
            }
        }
    }
}