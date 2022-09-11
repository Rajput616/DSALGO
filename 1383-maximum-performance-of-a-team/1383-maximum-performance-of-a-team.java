class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        long[][] effs = new long[n][2];
        for(int i = 0; i < n; ++i){
            effs[i][0] = efficiency[i];
            effs[i][1] = speed[i];
        }
        Arrays.sort(effs, (a,b) -> a[0] == b[0] ? (int)(b[1] - a[1]) : (int)(b[0] - a[0]));
        
        long sp = 0, mod = (long)1e9 + 7;
        long ans = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i = 0; i < n; ++i){
            if(pq.size() == k){
                sp -= pq.poll();
            }
            sp += effs[i][1];
            pq.offer(effs[i][1]);
            ans = Math.max(ans, sp * effs[i][0]);
        }
        return (int)(ans%mod);
    }
}




// class Solution {
//     public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
//         return maxPerform(0, n, 0, 0, speed, efficiency, k);
//     }
//     private int maxPerform(int i, int n, int prevS, int preE, int[] s, int[] e, int k){
//         if(i >= n || k == 0) return 0;
//         int mod = (int)1e9 + 7;
        
//         long maxP = maxPerform(i+1, n, prevS, preE, s, e, k) % mod;
//         if(preE == 0){
//             maxP = Math.max(maxP, s[i] * e[i] + maxPerform(i+1, n, s[i], e[i], s, e, k-1));
//             maxP %= mod;
//         } else{
//             prevS += s[i];
//             preE = Math.min(preE, e[i]);
//             maxP = Math.max(maxP, prevS * preE + maxPerform(i+1, n, prevS, preE, s, e, k-1));
//             maxP %= mod;
//         }
//         return (int)maxP;
//     }
// }