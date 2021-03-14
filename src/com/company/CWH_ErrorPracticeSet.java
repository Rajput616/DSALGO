package com.company;

import java.util.Scanner;

class NewException extends Exception{
    @Override
    public String getMessage() {
        return "You got a Exception";
    }
}

public class CWH_ErrorPracticeSet {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] max = new int[4];
        max[0] = 500;
        max[1] = 400;
        max[2] = 300;
        max[3] = 200;
        int index;
//        int i = 1;
//        boolean flag = true;
            System.out.println("Enter index : ");
            index = scn.nextInt();
            if(index<0 || index>3) {
                try {
                    throw new NewException();
                } catch (NewException e) {
                    System.out.println(e.getMessage());
                }
            }
            else{
                System.out.println("The array value is : " + max[index]);
            }
//            catch(ArithmeticException e){
//                i++;
//                System.out.println("HEHE");
//            }
//            catch(IllegalArgumentException e){
//                i++;
//                System.out.println("HAHA");
//            }
//            catch(ArrayIndexOutOfBoundsException e){
//                i++;
//                System.out.println("HOHO");
//            }

    }
}
