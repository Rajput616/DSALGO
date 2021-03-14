package com.company;

import java.util.Scanner;

public class NewStairCase {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int now = stCase(n);
        System.out.println(now);
    }
    public static int stCase(int n) {
        if(n < 0)
            return 0;
        if(n == 0)
            return 1;
        if(n == 2)
            return n;
        if(n == 3)
            return 4;

        return stCase(n-1) + stCase(n-2) + stCase(n-3);
    }
}
