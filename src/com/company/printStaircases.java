package com.company;

import java.util.Scanner;

public class printStaircases {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        printStairpath(n , "");
    }
    public static void printStairpath(int n ,String asf) {
        if(n == 0){
            System.out.println(asf);
            return;
        }
        if(n < 0){
            return;
        }
        printStairpath(n - 1 , asf + 1);
        printStairpath(n - 2 , asf + 2);
        printStairpath(n - 3 , asf + 3);
    }
}
