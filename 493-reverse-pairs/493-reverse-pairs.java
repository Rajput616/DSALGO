class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n-1, new int[n]);
    }
    private int mergeSort(int[] nums, int left, int right, int[] temp){
        if(left >= right) return 0;
        
        int revPair = 0;
        int mid = (left + right) >> 1;
        revPair += mergeSort(nums, left, mid, temp);
        revPair += mergeSort(nums, mid+1, right, temp);
        
        revPair += merge(nums, left, mid+1, right, temp);
        return revPair;
    }
    private int merge(int[] nums, int left, int mid, int right, int[] temp){
        int i = left, k = left, j = mid;
        int revPair = 0;
        for(; i < mid; ++i){
            while(j <= right && nums[i] > 2L*nums[j]) j++;
            revPair += (j - mid);
        }
        i = left; j = mid;
        while(i <= mid-1 && j <= right){
            if(nums[i] <= nums[j]) temp[k++] = nums[i++];
            else {
                temp[k++] = nums[j++];
            }
        }
        
        while(i <= mid-1) temp[k++] = nums[i++];
        while(j <= right) temp[k++] = nums[j++];
        for(i = left; i <= right; ++i) nums[i] = temp[i];
        return revPair;
    }
}