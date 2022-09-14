class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length; 
        Set<List<Integer>> set = new HashSet();
        for(int i = 0; i < n-3; ++i){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < n-2; ++j){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                
                int left = j+1, right = n-1;
                while(left < right){
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        set.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    } else if(sum > target){
                        right--;
                    } else{
                        left++;
                    }
                }
            }
        }
        return new ArrayList(set);
    }
}