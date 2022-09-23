class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList();
        backtrack(0, s, ans, new ArrayList());
        return ans;
    }
    
    private void backtrack(int index, String s, List<List<String>> list, List<String> curr){
        if(index == s.length()){
            list.add(new ArrayList(curr));
            return;  
        } 
        
        
        for(int i = index; i < s.length(); ++i){
            if(isPalindrome(s, index, i)){
                curr.add(s.substring(index, i+1));
                backtrack(i+1, s, list, curr);
                curr.remove(curr.size()-1);
            }
        }
        
        
    }
    private boolean isPalindrome(String s, int i, int j){
        while(i <= j && s.charAt(i) == s.charAt(j)){
            i++;
            j--;
        }
        return i > j;
    }
}