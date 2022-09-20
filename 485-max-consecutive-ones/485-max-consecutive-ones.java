class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, total = 0;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] == 1) count++;
            else {
                total = Math.max(total, count);
                count = 0;
            }
        }
        return Math.max(total, count);
    }
}