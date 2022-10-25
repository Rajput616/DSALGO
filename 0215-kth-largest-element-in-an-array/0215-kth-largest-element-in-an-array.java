class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int start = 0, end = len-1;
        while(start <= end){
            int pivot = partition(start, end, nums);
            
            if(pivot < len-k) start = pivot + 1;
            else if(pivot > len-k) end = pivot - 1;
            else return nums[pivot];
        }
        return -1;
    }
    
    private int partition(int start, int end, int[] nums){
        int pivot = start, temp;
        while(start <= end){
            while(start <= end && nums[start] <= nums[pivot]) start++;
            while(start <= end && nums[end] > nums[pivot]) end--;
            
            if(start > end) break;
            swap(nums, start, end);
        }
        swap(nums, end, pivot);
        return end;
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/*
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int i = 0; i < nums.length; ++i){
            if(i > k-1){
                if(nums[i] > pq.peek()){
                    pq.remove();
                    pq.add(nums[i]);
                }
            } else{
                pq.add(nums[i]);    
            }
        }
        return pq.peek();
    }

*/