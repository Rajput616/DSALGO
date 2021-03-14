package com.company;

import java.util.Scanner;

public class firstIndex {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = scn.nextInt();
        }
        int x = scn.nextInt();
        boolean fi = FirstIndex(a, 0, x);
        System.out.println(fi);
    }

    public static boolean FirstIndex(int[] arr, int idx, int x) {
        if(idx == arr.length || arr[idx] == x) {
            if(arr[idx] == x) {
                return true;
            }
            else {
                return false;
            }
        }
        return FirstIndex(arr, idx + 1 , x );
    }
    }
