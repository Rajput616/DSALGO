//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
	    
	    //reading input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//reading total testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    
		    //reading number of eggs and floors
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    
		    //calling eggDrop() method of class
		    //EggDrop
		    System.out.println(new Solution().eggDrop(n, k));
		}
	}
}



// } Driver Code Ends


class Solution 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int eggDrop(int n, int k) 
	{
	    return checkEgg(n, k, new int[n+1][k+1]);
	}
	private static int checkEgg(int eggs, int floors, int[][] dp){
	    if(floors <= 1) return floors;
	    if(eggs == 1) return floors;
	    
	    if(dp[eggs][floors] != 0) return dp[eggs][floors];
	    
	    int moves = (int)1e9;
	    for(int i = 1; i <= floors; ++i){
	        int currMoves = 1 + Math.max(checkEgg(eggs-1, i-1, dp), checkEgg(eggs, floors-i, dp));
	        moves = Math.min(moves, currMoves);
	    }
	    
	    return dp[eggs][floors] = moves;
	}
}