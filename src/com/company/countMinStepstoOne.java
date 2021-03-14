package com.company;

import java.util.Scanner;

public class countMinStepstoOne {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int i = countMinSteps(n, 0);
        System.out.println(i);
    }

    public static int countMinSteps(int n, int count) {
        if (n == 1)
            return count;
        int a = countMinSteps(n-1,count + 1);
        int min = a;
        if(n%2 == 0)
            {
                int b = countMinSteps(n / 2, count + 1);
                if(b < min)
                    min = b;
            }
        if(n%3 == 0) {
            int c = countMinSteps(n / 3, count + 1);
            if(c < min)
                min = c;
        }
          return min;
    }
}