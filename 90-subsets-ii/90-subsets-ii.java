class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set = new HashSet();
        Arrays.sort(nums);
        backtrack(nums.length-1, nums, set, new ArrayList());
        return new ArrayList(set);
    }
    private void backtrack(int i, int[] nums, Set<List<Integer>> set, List<Integer> curr){
        if(i < 0){
            
            set.add(new ArrayList(curr));
            return;
        } 
        
        backtrack(i-1, nums, set, curr);
        curr.add(nums[i]);
        backtrack(i-1, nums, set, curr);
        curr.remove(curr.size()-1);
    }
}