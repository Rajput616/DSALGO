package com.company;

import java.util.Scanner;

public class BuySellStockWithFee {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] prices = new int[n];
        for(int i = 0; i < prices.length; i++){
            prices[i] = scn.nextInt();
        }
        int fee = scn.nextInt();
        int obsp = -prices[0];
        int ossp = 0;

        for(int i = 1; i < prices.length; i++){
            int nbsp = Math.max(ossp - prices[i], obsp);
            int nssp = Math.max(obsp + prices[i] - fee, ossp);
            obsp = nbsp;
            ossp = nssp;
        }
        System.out.println(ossp);
    }
}
