class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque();
        int n = nums.length, index = 0; 
        int[] ans = new int[n-k+1];
        for(int i = 0; i < n; ++i){
            if(!dq.isEmpty() && dq.peekFirst() == i-k) dq.removeFirst();
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.removeLast();
            dq.addLast(i);
            if(i >= k-1)  ans[index++] = nums[dq.peekFirst()];
        }
        return ans;
    }
}