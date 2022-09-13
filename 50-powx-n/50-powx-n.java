class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        while(n != 0){
            if((n & 1) != 0)
                ans = n < 0 ? ans * (1/x) : ans * x;
            
            n /= 2;
            x *= x;
        }
        return ans;
    }
}

/*
    class Solution {
    public double myPow(double x, int n) {
        return calc(x, n);
    }
    private double calc(double x, long n){
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n < 0) return calc(1/x, -n);
        double half = calc(x, n/2);
        if(n % 2 != 0) return half * half * x;
        
        return half * half;
    }
}
*/