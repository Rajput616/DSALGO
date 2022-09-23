class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> set = new HashSet();
        backtrack(0, target, candidates, set, new ArrayList());
        return new ArrayList(set);
    }
    private void backtrack(int i, int target, int[] arr, Set<List<Integer>> set, List<Integer> curr){
        if(target == 0) {
            set.add(new ArrayList(curr));
            return;
        }
        if(i == arr.length) return;
        
        for(int index = i; index < arr.length; ++index){
            if(arr[index] <= target){
                curr.add(arr[index]);
                backtrack(index, target - arr[index], arr, set, curr);
                curr.remove(curr.size()-1);
            }
        }
    }
}