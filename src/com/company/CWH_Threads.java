package com.company;

class Day extends Thread{
    public void run(){
//        int i = 0;
//        while(i < 43282){
            System.out.println("Good Morning");
//            i++;
//        }

    }
}

class Guest extends Thread{
    public void run(){
//        int i = 0;
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        while(i < 43282){
            System.out.println("Welcome");
//            i++;
//        }
    }
}
public class CWH_Threads {
    public static void main(String[] args) {
        Day T1 = new Day();
        Guest T2 = new Guest();
//        T1.setPriority(1);
        System.out.println(T1.getState());
        System.out.println(T1.getPriority());
        T1.start();
//        try{
//            T1.join();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//        T2.setPriority(5);
        T2.start();
        System.out.println(T1.getState());
        System.out.println(T2.getPriority());
        System.out.println("Saurabh" + Thread.currentThread().getState());
    }
}
