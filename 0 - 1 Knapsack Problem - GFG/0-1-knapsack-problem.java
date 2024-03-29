//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    {
         int[][] dp = new int[n+1][W+1];
         for(int i = 1; i <= n; ++i){
             for(int w = 1; w <= W; ++w){
                 if(wt[i-1] <= w){
                    dp[i][w] = Math.max(dp[i-1][w], val[i-1] + dp[i-1][w-wt[i-1]]);
                } else{
                    dp[i][w] = dp[i-1][w];
                }
             }
         }
         return dp[n][W];
    } 
}

/*
Memoized
class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         return kS(n-1, W, wt, val, new int[n][W+1]);
    } 
    
    private static int kS(int i, int W, int[] wt, int[] val, int[][] dp){
        if(i < 0 || W <= 0) return 0;
        
        if(dp[i][W] != 0) return dp[i][W];
        
        if(wt[i] <= W){
            return dp[i][W] = Math.max(kS(i-1, W, wt, val, dp), val[i] + kS(i-1, W-wt[i], wt, val, dp));
        } else{
            return dp[i][W] = kS(i-1, W, wt, val, dp);
        }
    }
}
*/

// Recursive

// class Solution 
// { 
//     //Function to return max value that can be put in knapsack of capacity W.
//     static int knapSack(int W, int wt[], int val[], int n) 
//     { 
//          return kS(n-1, W, wt, val);
//     } 
    
//     private static int kS(int i, int W, int[] wt, int[] val){
//         if(i < 0 || W <= 0) return 0;
        
        
//         if(wt[i] <= W){
//             return val[i] + kS(i-1, W-wt[i], wt, val);
//         } else{
//             return kS(i-1, W, wt, val);
//         }
//     }
// }



