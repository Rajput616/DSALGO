package com.company;

//import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Rock_Paper_Scissor_Game {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Random random = new Random();
        int computer_choice = random.nextInt(3);
        System.out.println("Welcome Sir !!");
        System.out.println("Enter your choice.\n 0 for Rock\n" +
                " 1 for Paper\n 2 for Scissor");
        int user_input = scn.nextInt();
        if(computer_choice == 0){
            System.out.println("Computer choice : Rock");
        }
        else if(computer_choice == 1){
            System.out.println("Computer choice : Paper");
        }
        else{
            System.out.println("Computer choice : Scissor");
        }
        if(user_input == computer_choice){
            System.out.println("Game Draws!!");
        }
        else if((user_input == 0 && computer_choice == 2) ||
                (user_input == 1 && computer_choice == 0) ||
                (user_input == 2 && computer_choice == 1)){
            System.out.println("Congratulations! You Win!!");
        }
        else{
            System.out.println("Computer Wins! Better Luck Next Time!");
        }
    }
}
