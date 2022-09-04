class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ans = new ArrayList();
        
        for(int i = 1; i < 10; ++i)
            findAllNums(i, 1, n, k, ans);
        int[] arr = new int[ans.size()];
        for(int i = 0; i < ans.size(); ++i){
            arr[i] = ans.get(i);
        }
        return arr;
    }
    
    private void findAllNums(int num, int len, int n, int k, List<Integer> curr){
        if(len == n) {
            curr.add(num);
            return;
        }
        int lastDigit = num%10;
        for(int i = 0; i < 10; ++i){
            if(Math.abs(lastDigit - i) == k){
                findAllNums(num*10 + i, len+1, n, k, curr);    
            }
        }
        
    }
}