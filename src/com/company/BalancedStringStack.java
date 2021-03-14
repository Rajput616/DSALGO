package com.company;

import java.util.Scanner;
import java.util.Stack;

public class BalancedStringStack {
    public static void main(String[] args) {
        Stack<Character> stk = new Stack<>();
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ')') {
                if (stk.size() == 0) {
                    System.out.println(false);
                    return;
                }
                while (stk.peek() != '(') {
                    if (stk.peek() == '{' || stk.peek() == '[') {
                        System.out.println(false);
                        return;
                    } else {
                        stk.pop();
                    }
                }
                stk.pop();
            } else if (ch == '}') {
                if (stk.size() == 0) {
                    System.out.println(false);
                    return;
                }
                while (stk.peek() != '{') {
                    if (stk.peek() == '(' || stk.peek() == '[') {
                        System.out.println(false);
                        return;
                    } else {
                        stk.pop();
                    }
                }
                stk.pop();
            } else if (ch == ']') {
                if (stk.size() == 0) {
                    System.out.println(false);
                    return;
                }
                while (stk.peek() != '[') {
                    if (stk.peek() == '{' || stk.peek() == '(') {
                        System.out.println(false);
                        return;
                    } else {
                        stk.pop();
                    }
                }
                stk.pop();
            } else {
                stk.push(ch);
            }
        }
        System.out.println(stk.size() == 0);



    }
}
