class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        Set<Character> set = new HashSet();
        int i = 0, j = 0, max = 0;
        while(j < len){
            char ch = s.charAt(j);
            if(set.contains(ch)){
                while(i < j && set.contains(ch)) {
                    set.remove(s.charAt(i));
                    i++;
                }
                set.add(ch);
            } else{
                set.add(ch);
                max = Math.max(max, j-i+1);
            }
            j++;
        }
        return max;
    }
}