class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int low = 0, high = n-1;
        int waterStored = 0, leftMax = 0, rightMax = 0;;
        while(low <= high){
            if(height[low] <= height[high]){
                if(height[low] < leftMax)   waterStored += (leftMax - height[low]);
                else leftMax = height[low];
                
                low++;
            } else{
                if(height[high] < rightMax)   waterStored += (rightMax - height[high]);
                else  rightMax = height[high];
                
                high--;
            }
        }
        return waterStored;
    }
}