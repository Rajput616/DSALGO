package com.company;

interface MyCamera{
    void takeSnap();
    void recordVideo();
    private void greet(){
        System.out.println("Good Morning");
    }
    default void record4kVideo(){
        greet();
        System.out.println("Recording in 4k...");
    }
}

interface MyWifi{
    String[] getNetworks();
    void connectToNetwork(String network);
}

class MyCellPhone{
    void callNumber(int phoneNumber){
        System.out.println("Calling" + phoneNumber);
    }
    void pickCall(){
        System.out.println("Connecting...");
    }
}

class MySmartPhone extends MyCellPhone implements MyWifi,MyCamera{
    public void takeSnap(){
        System.out.println("Taking Snap");
    }
    public void recordVideo(){
        System.out.println("Taking Video");
    }
//    public void record4kVideo(){
//        System.out.println("Taking Snap & Recording in 4K");
//    }
    public String[] getNetworks(){
        System.out.println("Getting List of Networks");
        String[] networkList = {"Saurabh", "Kasim", "Shubham"};
        return networkList;
    }
    public void connectToNetwork(String network){
        System.out.println("Connecting to "+ network);
    }
}
public class Interfaces_in_java {
    public static void main(String[] args) {
        MySmartPhone ms = new MySmartPhone();
        ms.record4kVideo();
//        ms.greet();
        String[] arr = ms.getNetworks();
        for(String item : arr){
            System.out.println(item);
        }
    }
}
