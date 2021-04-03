package com.company;

public class BitManipulation_checkNoOfOnes {
    public static void main(String[] args) {
        int n = 19;
        int count = 0;
        while(n != 0){
            n = n & (n - 1);
            count++;
        }
        System.out.println (count);
    }
}
