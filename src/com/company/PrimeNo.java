package com.company;

import java.util.Scanner;

public class PrimeNo {


    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int flag = -1;
        int n = scn.nextInt();
        for(int i = 2 ; i * i <= n; i++){
            if( n % i == 0){
                flag = 0;
                break;
            }
        }
        if(flag == 0){
            System.out.println("False");
        } else{
            System.out.println("True");
        }
    }
}
