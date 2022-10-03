class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftSmaller = findNextSmaller(heights, 0, n-1, n, true);
        int[] rightSmaller = findNextSmaller(heights, n-1, 0, n, false);
        int maxArea = 0;
        for(int i = 0; i < n; ++i){
            maxArea = Math.max(maxArea, heights[i] * (rightSmaller[i] - leftSmaller[i] - 1));
        }
        return maxArea;
    }
    
    
    private int[] findNextSmaller(int[] arr, int left, int right, int n, boolean isLeft){
        int[] ans = new int[n];
        Stack<Integer> st = new Stack();
        if(isLeft){
            while(left <= right){
                if(left == 0){
                   ans[left] = -1; 
                } else{
                    while(!st.isEmpty() && arr[st.peek()] >= arr[left]) st.pop();
                    ans[left] = st.isEmpty() ? -1 : st.peek();
                }
                st.push(left);
                left++;
            }
        } else{
            while(left >= right){
                if(left == n-1){
                    ans[left] = n;
                } else{
                    while(!st.isEmpty() && arr[st.peek()] >= arr[left]) st.pop();
                    ans[left] = st.isEmpty() ? n : st.peek();
                }
                st.push(left);
                left--;
            }
        }
        return ans;
    }
}