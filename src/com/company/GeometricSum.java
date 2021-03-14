package com.company;

import java.util.Scanner;

public class GeometricSum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        double gs = geoSum(n);
        System.out.println(gs);
    }
    public static double geoSum(int n){
     if(n == 0){
         return 1;
     }
     return 1 / Math.pow(2,n) + geoSum(n-1);
    }
}
