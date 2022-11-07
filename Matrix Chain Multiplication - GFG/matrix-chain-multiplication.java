//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        int[][] dp = new int[N][N];
        for(int i = N-1; i >= 1; --i){
            for(int j = 1; j <= N-1; ++j){
                if(i == j) continue;
                int min = (int)1e9;
                for(int k = i; k < j; ++k){
                    int steps = arr[i-1] * arr[k] * arr[j] + dp[i][k] + dp[k+1][j];
                    min = Math.min(min, steps);
                }
                dp[i][j] = min;
            }
        }
        
        return dp[1][N-1];
    }
}

// class Solution{
//     static int matrixMultiplication(int N, int arr[])
//     {
//         return mcm(1, N-1, arr, new int[N][N]);
//     }
    
//     private static int mcm(int i, int j, int[] arr, int[][] dp){
//         if(i == j) return 0;
        
//         if(dp[i][j] != 0) return dp[i][j];
//         int min = (int)1e9;
//         for(int k = i; k < j; ++k){
//             int steps = arr[i-1] * arr[k] * arr[j] + mcm(i, k, arr, dp) + mcm(k+1, j, arr, dp);
//             min = Math.min(min, steps);
//         }
//         return dp[i][j] = min;
//     }
// }