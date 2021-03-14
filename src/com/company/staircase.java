package com.company;

import java.util.Scanner;

public class staircase {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in) ;
        int n = scn.nextInt();
        int ans = stairs(n);
        System.out.println(ans);

    }
    public static int stairs(int n){
        if(n<0)
            return 0;
        if(n==0)
            return 1;
        int a,b,c;
        a = b = c =0;
        a = a + stairs(n-1);
        b = b + stairs(n-2);
        c = c + stairs(n-3);
        return (a + b + c);
    }
}
