class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quick(nums, 0, nums.length-1, nums.length-k);
    }
    
    private int quick(int[] nums, int left, int right, int k){
        int pivot = nums[right], start = left;
        for(int i = left; i < right; ++i){
            if(nums[i] <= pivot){
                swap(nums, i, start);
                start++;
            }
        }
        
        swap(nums, start, right);
        if(start > k) return quick(nums, left, start-1, k);
        else if(start < k) return quick(nums, start+1, right, k);
        else return nums[start];
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}