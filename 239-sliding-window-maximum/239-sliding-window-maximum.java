class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque();
        int n = nums.length; 
        int[] ans = new int[n-k+1];
        for(int i = 0; i < n; ++i){
            if(i >= k)  ans[i-k] = nums[dq.peekFirst()];
            
            if(!dq.isEmpty() && dq.peekFirst() == i-k) dq.removeFirst();
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.removeLast();
            dq.addLast(i);
        }
        ans[n-k] = nums[dq.peekFirst()];
        return ans;
    }
}