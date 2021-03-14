package com.company;

import java.util.Scanner;

public class SumofDigits {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int sod = sumDigits(n);
        System.out.println(sod);
    }
    public static int sumDigits(int n ){
        if(n / 10 == 0)
            return n;
        return n%10 + sumDigits(n/10);
    }
}
