class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> digits = new ArrayList();
        int fact = 1;
        for(int i = 1; i < n; ++i){
            fact *= i;
            digits.add(i);
        }
        digits.add(n);
        k--;
        String ans = "";
        while(true){
            ans = ans + digits.get(k/fact);
            digits.remove(k/fact);
            if(digits.isEmpty()) break;
            k %= fact;
            fact /= digits.size();
        }
        return ans;
    }
}
