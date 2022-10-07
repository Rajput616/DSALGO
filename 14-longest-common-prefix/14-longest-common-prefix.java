class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        
        String first = strs[0], prefix = "";
        for(int i = 0; i < first.length(); ++i){
            char ch = first.charAt(i);
            for(int j = 1; j < strs.length; ++j){
                if(i >= strs[j].length() || ch != strs[j].charAt(i)) return prefix;
            }
            prefix += ch;
        }
        return prefix;
    }
}