class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int n1 = nums1.length, n2 = nums2.length;
        int i = 0, j = n1;
        while(i <= j){
            int cut1 = (i + j) >> 1;
            int cut2 = ((n1 + n2 + 1) >> 1) - cut1;
            
            int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1-1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2-1];
            
            int right1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];
            
            if(left1 <= right2 && left2 <= right1){
                if((n1 + n2) % 2 != 0)
                    return Math.max(left1, left2);
                return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            } else if(left1 > right2) j = cut1-1;
            else i = cut1+1;
        }
        return 0.0;
    }
}