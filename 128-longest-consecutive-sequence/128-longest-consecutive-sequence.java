class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet();
        for(int num : nums) set.add(num);
        
        int count = 0;
        for(int num : set){
            if(set.contains(num-1)) continue;
            
            int c = 0;
            while(set.contains(num)){
                num++;
                c++;
            } 
            count = Math.max(count, c);
        }
        return count;
    }
}