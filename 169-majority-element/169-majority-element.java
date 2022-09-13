class Solution {
    public int majorityElement(int[] nums) {
        int mE = nums[0], count = 1;
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] == mE){
                count++;
            } else{
                count--;
                if(count == 0) {
                    mE = nums[i];
                    count = 1;
                }
            }
        }
        return mE;
    }
}