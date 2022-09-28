class Solution {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        while(i <= j){
            int mid = (i + j) >> 1;
            if(nums[mid] == target) return mid;
            else if(nums[i] <= nums[mid]){
                if(target < nums[i] || target > nums[mid]) i = mid+1;
                else j = mid-1;
            } else {
                if(target > nums[j] || target < nums[mid]) j = mid-1;
                else i = mid+1;
            }
        }
        return -1;
    }
}