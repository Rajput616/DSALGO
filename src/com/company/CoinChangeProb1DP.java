package com.company;
import java.util.Scanner;
public class CoinChangeProb1DP {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < coins.length; i++)
            coins[i] = scn.nextInt();
        int amt = scn.nextInt();
        long[][] t = new long[n + 1][amt + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < amt + 1; j++) {
                if (i == 0) {
                    t[i][j] = 0;
                }
                if (j == 0) {
                    t[i][j] = 1;
                }

            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < amt + 1; j++) {
                if (coins[i - 1] <= j) {
                    t[i][j] = t[i][j - coins[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        System.out.println(t[n][amt]);
    }
}
