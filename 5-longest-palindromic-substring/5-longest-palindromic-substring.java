class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(), start = 0, maxLen = 1;
        char[] ch = s.toCharArray();
        boolean[][] grid = new boolean[n][n];
        for(int i = 0; i < n; ++i){
            grid[i][i] = true;
            if(i != n-1 && ch[i] == ch[i+1]) {
                grid[i][i+1] = true;
                start = i;
                maxLen = 2;
            }
        }
        
        for(int k = 3; k <= n; ++k){
            for(int i = 0; i < n-k+1; ++i){
                int j = k + i -1;
                if(ch[i] == ch[j] && grid[i+1][j-1]){
                    grid[i][j] = true;
                    if(k > maxLen){
                        maxLen = k;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start+maxLen);
    }
}

/*
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
*/