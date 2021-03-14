package com.company;
import java.util.*;

public class pairSocksProblem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int[] hash = new int[300];
        for(int i=0; i<n; i++){
            hash[in.nextInt()]++;
        }
        long ans=0;
        for(int p: hash){
            ans+=p/2;
        }
        System.out.println(ans);
    }
}
