class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        String s = "1";
        for(int i = 1; i < n; ++i){
            int count = 0, num = s.charAt(0)-'0';
            StringBuilder temp = new StringBuilder();
            for(int j = 0; j < s.length(); ++j){
                int digit = s.charAt(j) - '0';
                if(digit == num){
                    count++;
                } else{
                    temp.append(count + "" + num);
                    count = 1;
                    num = digit;
                }
            }
            temp.append(count + "" + num);
            s = temp.toString();
        }
        return s;
    }
}