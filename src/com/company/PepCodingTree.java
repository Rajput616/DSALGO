package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class PepCodingTree {

    public static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static void display(Node node){
        StringBuilder str = new StringBuilder(node.data + " -> ");
        for(Node child : node.children){
            str.append(child.data).append(", ");
        }
        str.append(".");
        System.out.println(str);
        for(Node child : node.children){
            display(child);
        }
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = new Node();
        Stack<Node> st = new Stack<>();
        for(int i : arr){
            if(i == -1){
                st.pop();
            } else{
                Node t = new Node();
                t.data = i;

                if(st.size() > 0){
                    st.peek().children.add(t);
                } else {
                    root = t;
                }
                st.push(t);
            }
        }
        display(root);
    }
}