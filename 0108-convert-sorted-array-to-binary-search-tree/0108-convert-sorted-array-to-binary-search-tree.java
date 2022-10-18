
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeBST(0, nums.length-1, nums);
    }
    
    private TreeNode makeBST(int i, int j, int[] nums){
        if(i > j) return null;
        int mid = (i + j) / 2;
        TreeNode root = new TreeNode(nums[mid], makeBST(i, mid-1, nums), makeBST(mid+1, j, nums));
        return root;
    }
}