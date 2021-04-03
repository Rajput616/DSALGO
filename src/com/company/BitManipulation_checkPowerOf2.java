package com.company;

public class BitManipulation_checkPowerOf2 {
    public static void main(String[] args) {
        int n = 16;
        System.out.println ((n & (n - 1)) == 0);
    }
}
