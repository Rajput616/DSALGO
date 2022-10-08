/*
class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
*/
class Solution {
    public int strStr(String haystack, String needle) {
        String st = needle + "$" + haystack;
        int len = st.length();
        int[] lps = new int[len];
        computeLPS(lps, st, len);
        int nLen = needle.length();
        for(int i = nLen+1; i < len; ++i){
            if(lps[i] == nLen) return i - 2*nLen;
        }
        return -1;
        
    }
    private void computeLPS(int[] lps, String st, int slen){
        int len = 0, i = 1;
        while(i < slen){
            if(st.charAt(i) == st.charAt(len)){
                lps[i] = len+1;
                len++;
                i++;
            } else{
                if(len != 0) len = lps[len-1];
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}

