class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] chars = new int[26];
        for(int i = 0; i < s.length(); ++i){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            chars[ch1-'a']++;
            chars[ch2-'a']--;
        }
        for(int i = 0; i < 26; ++i) if(chars[i] < 0) return false;
        return true;
    }
}