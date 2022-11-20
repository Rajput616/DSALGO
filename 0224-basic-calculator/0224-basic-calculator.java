class Solution {
    public int calculate(String s) {
        int res = 0, sign = 1;
        Stack<Integer> st = new Stack();
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(ch == '+') sign = 1;
            else if(ch == '-') sign = -1;
            else if(ch >= '0' && ch <= '9'){
                int temp = i;
                int num = 0;
                while(temp < s.length() && Character.isDigit(s.charAt(temp))){
                    num *= 10;
                    num += (s.charAt(temp) -'0');
                    temp++;
                }
                res += sign*num;
                i = temp-1;
            } else if(ch == '('){
                st.push(res);
                st.push(sign);
                res = 0; sign = 1;
            } else if(ch == ')'){
                res *= st.pop();
                res += st.pop();
            }
        }
        return res;
    }
}