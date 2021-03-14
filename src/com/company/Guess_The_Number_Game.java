package com.company;
import java.util.Random;
import java.util.Scanner;
class Game{
    private final int number;
    Random random = new Random();
    Game(){
        number = random.nextInt( 100);
    }
    public int getNumber(){
        return number;
    }
    public boolean isCorrectNumber(int user_input){
        return user_input == number;
    }
    public int Score(int no_of_guesses){
        return 11 - no_of_guesses;
    }
}
public class Guess_The_Number_Game {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Game obj = new Game();
        System.out.println("Welcome Sir");
        System.out.println("Guess the No. b/w 0 - 99 :");
        System.out.print("\tEnter Your Choice : ");
        for(int i = 1; i <= 10; i++) {
            int user_input = scn.nextInt();
            boolean check = obj.isCorrectNumber(user_input);
            if (check) {
                System.out.println("Congratulations !! You Guessed the No.");
                System.out.println("Your Score is " + obj.Score(i) + " out of 10");
                break;
            } else {
                if (user_input > obj.getNumber()) {
                    System.out.print("Your No. is Greater -> ");
                }
                else
                    System.out.print("Your No. is Smaller -> ");
            }
            if (i == 10){
                System.out.println("You Failed!! Your Score is 0.");
                System.out.println("The Number is" + obj.getNumber());
                break;
            }
            System.out.println("Enter new choice");
        }
        System.out.println("THANKS FOR PLAYING!!");
    }
}
