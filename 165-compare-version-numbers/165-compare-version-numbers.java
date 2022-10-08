/*
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("[.]");
        String[] v2 = version2.split("[.]");
        int i = 0, j = 0, n = v1.length, m = v2.length;
        while(i < n || j < m){
            int num1 = 0, num2 = 0;
            if(i < n){
                num1 = Integer.parseInt(v1[i]);
                i++;
            } 
            if(j < m){
                num2 = Integer.parseInt(v2[j]);
                j++;
            }
            if(num1 < num2) return -1;
            else if(num2 < num1) return 1;
        }
        return 0;
    }
}
*/


class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int n = v1.length, m = v2.length;
        int max = Math.max(n, m);
        for(int i = 0; i < max; ++i){
            int num1 = i < n ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < m ? Integer.parseInt(v2[i]) : 0;
            
            if(num1 < num2) return -1;
            else if(num2 < num1) return 1;
            
        }
        return 0;
    }
}