//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Sol obj = new Sol();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int wordBreak(String A, ArrayList<String> B )
    {
        Set<String> set = new HashSet();
        for(String s : B) set.add(s);
        int len = A.length();
        return check(0, len, A, set, new int[len]);
    }
    
    private static int check(int i, int len, String s, Set<String> set, int[] dp){
        if(i == len) return 1;
        
        if(dp[i] != 0) return dp[i];
        for(int index = i; index < len; ++index){
            if(set.contains(s.substring(i, index+1))){
                if(check(index+1, len, s, set, dp) == 1) return dp[i] = 1;
            }
        }
        return dp[i] = 0;
    }
}