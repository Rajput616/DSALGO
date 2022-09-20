class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n-2; ++i){
            int low = i+1, high = n-1;
            while(low < high){
                int target = nums[i] + nums[low] + nums[high];
                if(target == 0){
                    set.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                } else if(target > 0){
                    high--;
                } else low++;
            }
        }
        return new ArrayList(set);
    }
}