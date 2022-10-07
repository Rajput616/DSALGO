class Solution {
    public String longestPalindrome(String s) {
        
        int max = 1, start = 0;
        for(int i = 0; i < s.length()-1; ++i){
            int p1 = getPalindrome(s, i, i);
            if(p1 > max){
                start = i - p1/2;
                max = p1;
            }
            int p2 = getPalindrome(s, i, i+1);
            if(p2 > max){
                start = (i+1) - (p2/2);
                max = p2;
            }
        }
        return s.substring(start, start + max);
    }
    private int getPalindrome(String s, int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return j - i - 1;
    }
}