package com.company;

import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int  bin = 0;
        int pn = 1;
        while(n != 0){
            int rem = n % 2;
            n = n / 2;
            bin = pn * rem + bin;
            pn = pn * 10;
        }
        System.out.println(bin);
    }
}
