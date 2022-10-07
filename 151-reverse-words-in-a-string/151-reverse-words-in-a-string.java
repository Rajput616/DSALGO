class Solution {
    public String reverseWords(String s) {
        String[] word = s.trim().split(" ");
        String ans = "";
        for(int i = word.length-1; i >= 0; --i) {
            if(word[i].length() == 0) continue;
            if(i != 0)
                ans += word[i] + " ";
            else ans += word[i];
            
        }
        return ans;
    }
}