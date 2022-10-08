class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        String s = "1";
        for(int i = 1; i < n; ++i){
            int count = 0, num = 0;
            String temp = "";
            for(int j = 0; j < s.length(); ++j){
                int digit = s.charAt(j) - '0';
                if(j == 0){
                    count = 1;
                    num = digit;
                } else{
                    if(digit == num){
                        count++;
                    } else{
                        temp += (count + "" + num);
                        count = 1;
                        num = digit;
                    }
                }
            }
            temp += (count + "" + num);
            s = temp;
        }
        return s;
    }
}