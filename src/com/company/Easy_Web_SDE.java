package com.company;

import java.util.*;


public class Easy_Web_SDE {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String my_string = scn.nextLine();
        String[] para = my_string.split("[\\-., ?!():”“]+");
        HashMap<ArrayList<String>, Integer> hm = new HashMap<> ();
        for(String s1 : para){
            if(hm.size() > 0){
                ArrayList<String>[] keys = hm.keySet ().toArray (new ArrayList[0]);
                for(ArrayList<String> s2  : keys){
                    if(hm.get(s2) == 1){
                        if(LCS(s2.get(0) , s1) >= 4 ){
                            int ov = hm.get(s2);
                            hm.remove(s2);
                            s2.add(s1);
                            hm.put(s2,ov + 1);
                            break;
                        } else{
                            ArrayList<String> al = new ArrayList<> ();
                            al.add(s1);
                            hm.put(al, 1);
                        }
                    } else {
                        for(int i = 0; i < s2.size (); i++){
                            String str = s2.get(i);
                            if(LCS(str , s1) >= 4){
                                int ov = hm.get(s2);
                                hm.remove(s2);
                                s2.add(s1);
                                hm.put(s2,ov + 1);
                                break;
                            } else{
                                ArrayList<String> al = new ArrayList<> ();
                                al.add(s1);
                                hm.put(al, 1);
                            }
                        }
                    }
                }
            } else{
                ArrayList<String> al = new ArrayList<> ();
                al.add(s1);
                hm.put(al, 1);
            }

        }
        System.out.println (hm);

    }

    public static int LCS(String text1 , String text2){
        int n = text1.length();
        int m = text2.length();
        int[][] t = new int[n+1][m+1];
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < m+1; j++){
                if(i == 0 || j == 0){
                    t[i][j] = 0;
                }
            }
        }
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j< m+1; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else{
                    t[i][j] = Math.max(t[i-1][j] , t[i][j-1]);
                }
            }
        }
        return t[n][m];
    }
}