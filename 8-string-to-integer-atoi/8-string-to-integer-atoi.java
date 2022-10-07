class Solution {
    public int myAtoi(String s) {
        boolean isNeg = false;
        
        s = s.trim();
        if(s.length() == 0) return 0;
        int i = 0;
        if(s.charAt(i) == '-' || s.charAt(i) == '+'){
            isNeg = s.charAt(i) == '-';
            i++;
        }
        int total = 0;
        while(i < s.length() && Character.isDigit(s.charAt(i))){
            int num = s.charAt(i) - '0';
            if((total == Integer.MAX_VALUE / 10 && num > 7) || total > Integer.MAX_VALUE/10) 
                return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            
            total *= 10;
            total += num;
            i++;
        }
        return isNeg ? -total : total;
    }
}