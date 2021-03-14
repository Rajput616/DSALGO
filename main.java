package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn =new Scanner(System.in);
        int stairs = scn.nextInt();
        int ans = Staircase(stairs,0,0);
        System.out.println(ans);
    }
    public static int Staircase(int stairs,int i,int count){
        if(i==stairs) {
            count++;
            return count;
        }
        if(i>stairs)
            return count;
        int a = Staircase(stairs,i+1,count);
        int b = Staircase(stairs,i+2,count);
        int c = Staircase(stairs,i+3,count);
        return a+b+c;
    }
}
