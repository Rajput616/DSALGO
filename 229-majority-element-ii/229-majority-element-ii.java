class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = 0, num2 = 0, c1 = 0, c2 = 0, n = nums.length;
        for(int num : nums){
            if(num == num1) c1++;
            else if(num == num2) c2++;
            else if(c1 == 0){
                num1 = num;
                c1++;
            } else if(c2 == 0) {
                num2 = num;
                c2++;
            } else{
                c1--;
                c2--;
            }
        }
        c1 = 0; c2 = 0;
        for(int num : nums){
            if(num == num1) c1++;
            else if(num == num2) c2++;
        }
        List<Integer> ans = new ArrayList();
        if(c1 > n/3) ans.add(num1);
        if(c2 > n/3) ans.add(num2);
        return ans;
    }
}