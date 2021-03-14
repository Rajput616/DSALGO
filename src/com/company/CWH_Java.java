package com.company;
//class employee{
//    int salary;
//    String name;
//    public int getSalary(){
//        return salary;
//    }
//    public String getName(){
//        return name;
//    }
//    public void setName(String n){
//        name = n;
//    }
//}
//class Cellphone{
//    public void method1(){
//        System.out.println("Ringing...");
//    }
//    public void method2(){
//        System.out.println("Vibrating...");
//    }
//    public void method3(){
//        System.out.println("Silent...");
//    }
//}
//class square{
//    int side;
//    public int perimeter(){
//        return 4*side;
//    }
//    public int area(){
//        return side*side;
//    }
//}
class TommyVecetti{
    public void hit(){
        System.out.println("Hitting");
    }
    public void run(){
        System.out.println("Running");
    }
    public void fire(){
        System.out.println("Firing");
    }
}
public class CWH_Java {
    public static void main(String[] args) {
////        employee S = new employee();
////        S.name = "Saurabh";
////        S.salary = 50000;
////        System.out.println("Salary is : " + S.getSalary());
////        System.out.println("Name is : "+ S.getName());
////        String s = "Saurabh Rajput";
////        S.setName(s);
////        System.out.println("The new Name is : " + S.getName());
//     Cellphone mi = new Cellphone();
//     mi.method1();
//     mi.method2();
//     mi.method3();
//        square s = new square();
//        s.side = 5;
//        System.out.println( "Perimeter of Square is "+ s.perimeter() + " cm");
//        System.out.println( "Area of Square is "+ s.area() + " sq. cm");
        TommyVecetti RcGames = new TommyVecetti();
        RcGames.hit();
        RcGames.run();
        RcGames.fire();
    }
}
