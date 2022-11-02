class Solution {
    public int maxProduct(int[] nums) {
        int totalMax = nums[0], curr_max = nums[0], curr_min = nums[0];
        for(int i = 1; i < nums.length; ++i){
            int temp = curr_max;
            curr_max = Math.max(nums[i], Math.max(curr_max*nums[i], curr_min * nums[i]));
            curr_min = Math.min(nums[i], Math.min(temp * nums[i], curr_min * nums[i]));
            
            totalMax = Math.max(totalMax, curr_max);
        }
        return totalMax;
    }
}