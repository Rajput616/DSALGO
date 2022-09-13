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