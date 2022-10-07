class Solution {
    public int repeatedStringMatch(String a, String b) {
        boolean[] chars = new boolean[26];
        for(char ch : a.toCharArray()) chars[ch-'a'] = true;
        for(char ch : b.toCharArray()) {
            if(!chars[ch - 'a']) return -1;
        }
        
        int count = b.length() / a.length();
        StringBuilder sb = new StringBuilder(a.repeat(count));
        for(int i = 0; i <= 2; ++i){
            if(sb.indexOf(b) >= 0) return count+i;    
            sb.append(a);
        }
        return -1;
        
    }
}