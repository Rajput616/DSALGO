class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n-2; ++i){
            if(i > 0 && nums[i-1] == nums[i]) continue;
            int low = i+1, high = n-1;
            while(low < high){
                int target = nums[i] + nums[low] + nums[high];
                if(target == 0){
                    ans.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while(low < high && nums[low] == nums[low+1]) low++;
                    while(low < high && nums[high] == nums[high-1]) high--;
                    low++;
                    high--;
                } else if(target > 0){
                    high--;
                } else low++;
            }
        }
        return ans;
    }
}