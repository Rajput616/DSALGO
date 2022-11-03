class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, len = 0;
        int[] arr = new int[n];
        arr[len++] = nums[0];
        for(int i = 1; i < n; ++i){
            if(nums[i] < arr[0]) arr[0] = nums[i];
            else if(nums[i] > arr[len-1]) arr[len++] = nums[i];
            else {
                int index = Arrays.binarySearch(arr, 0, len, nums[i]);
                if(index < 0) index = -index-1;
                arr[index] = nums[i];
            }
        }
        return len;
    }
}

// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
        
//         int[] dp = new int[n];
//         Arrays.fill(dp, 1);
        
//         int maxLen = 1;
//         for(int i = 1; i < n; ++i){
//             for(int j = 0; j <= i; ++j){
//                 if(nums[j] < nums[i] && dp[i] < 1 + dp[j])
//                     dp[i] = 1 + dp[j];
//             }
//             maxLen = Math.max(maxLen, dp[i]);
//         }
//         return maxLen;        
//     }
// }