package com.company;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
public class TimeChanger {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String time = scn.next();

        DateFormat in_format = new SimpleDateFormat("hh:mm:ssaa");
        DateFormat out_format = new SimpleDateFormat("HH:mm:ss");

        Date date = null;
        try{
            date = in_format.parse(time);
        } catch (Exception e){
            e.printStackTrace();
        }
        if(date != null){
            String my_date = out_format.format(date);
            System.out.println(my_date);
        }

//        String hour_st = time.substring(0 , 2);
//        String rest_time = time.substring(2 , 8);
//        int hours = Integer.parseInt(hour_st);
//        if(time.substring(8).equals("PM")){
//            System.out.println(hours + 12 + rest_time);
//        } else {
//            if(hours < 10) {
//                System.out.println("0" + hours + rest_time);
//            } else {
//                System.out.println(hours + rest_time);
//            }
//        }

    }
}
