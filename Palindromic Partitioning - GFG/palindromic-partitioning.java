//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int palindromicPartition(String str)
    {
        int len = str.length();
        if(isPalin(str, 0, len-1)) return 0;
        
        return partition(0, len, str, new int[len])-1;
    }
    
    private static int partition(int i, int len, String str, int[] dp){
        if(i == len) return 0;
        
        if(dp[i] != 0) return dp[i]; 
        int cuts = (int)1e9;
        for(int index = i; index < len; ++index){
            if(isPalin(str, i, index)){
                int currCuts = 1 + partition(index+1, len, str, dp);
                cuts = Math.min(currCuts, cuts);
            }
        }
        return dp[i] = cuts;
    }
    
    private static  boolean isPalin(String s, int i, int j){
        while(i <= j && s.charAt(i) == s.charAt(j)){
            i++;
            j--;
        }
        return i > j;
    }
}