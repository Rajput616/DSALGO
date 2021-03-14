package com.company;

import java.util.Scanner;

class Solution {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt ();
        int c = scn.nextInt ();
        if(a < 0 || b < 0 || c < 0){
            System.out.println ("WRONG INPUT");
        } else {
            int d;
            d = 2 * b * c + 3 * (b/2) * c;
            if(d >= a){
                System.out.println (1);
            } else{
                System.out.println (0);
            }
        }
    }
}