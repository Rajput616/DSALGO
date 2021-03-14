package com.company;

interface basicAnimal{
    void eat();
    void sleep();
}
class monkey{
    void jump(){
        System.out.println("Monkey is Jumping");
    }
    void bite(){
        System.out.println("Monkey can bite you");
    }
}

class Human extends monkey implements basicAnimal{
    @Override
    public void eat(){
        System.out.println("Eating");
    }
    @Override
    public void sleep(){
        System.out.println("Sleeping");
    }

    public void speak(){
        System.out.println("Speaking");
    }
    public void jump(){
        System.out.println("Human is Jumping");
    }
    public void bite(){
        System.out.println("Humans don't bite");
    }

}
public class CWH_Polymorphism {
    public static void main(String[] args) {
        Human hum = new Human();
        hum.eat();
        hum.sleep();
        hum.speak();
        hum.jump();
        hum.bite();
        monkey mon = new Human();
//        mon.speak(): -> Monkey cant use speak method
        mon.jump();
        mon.bite();
        basicAnimal cat = new Human();
        cat.eat();
        cat.sleep();
//        cat.speak(); -> Cat cant use speak Method

    }
}