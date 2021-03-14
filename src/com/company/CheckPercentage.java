package com.company;

import java.util.Scanner;

public class CheckPercentage {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks of Subject 1 : ");
        byte marks1 = sc.nextByte();
        System.out.print("Enter marks of Subject 2 : ");
        byte marks2 = sc.nextByte();
        System.out.print("Enter marks of Subject 3 : ");
        byte marks3 = sc.nextByte();
        System.out.print("Enter marks of Subject 4 : ");
        byte marks4 = sc.nextByte();
        System.out.print("Enter marks of Subject 5 : ");
        byte marks5 = sc.nextByte();
        int TotalMarks = marks1 + marks2 + marks3 + marks4 + marks5;
        float percentage = TotalMarks/5;
        System.out.println("Your Percentage according to your marks is : ");
        System.out.println(percentage);
    }
}
