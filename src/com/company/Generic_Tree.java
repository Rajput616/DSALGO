package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class Generic_Tree {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node){
        String str = node.data + "-> ";
        for(Node child: node.children){
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for(Node child: node.children){
            display(child);
        }
    }

    public static int size(Node node){
        int s = 0;
        for(Node child: node.children){
            int cs = size(child);
            s += cs;
        }
        s++;
        return s;
    }

    public static int max(Node node) {
        int max = Integer.MIN_VALUE;
        for(Node child: node.children){
            int cmax = max(child);
            max = Math.max(max, cmax);
        }
        max = Math.max(max, node.data);
        return max;
    }

    public static int height(Node node) {
        int ht = -1;
        for(Node child: node.children){
            int cht = height(child);
            ht = Math.max(cht, ht);
        }
        ht++;
        return ht;
    }

    public static void traversals(Node node){
        System.out.println("Node Pre " + node.data);

        for(Node child: node.children){
            System.out.println("Edge Pre " + node.data + "--" + child.data);
            traversals(child);
            System.out.println("Edge Post " + node.data + "--" + child.data);
        }

        System.out.println("Node Post " + node.data);
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        Node root = null;
        Stack<Node> st = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == -1){
                st.pop();
            } else{
                Node t = new Node();
                t.data = arr[i];

                if(st.size() > 0){
                    st.peek().children.add(t);
                } else{
                    root = t;
                }
                st.push(t);
            }
        }
//        display(root);
//        System.out.println(size(root));
//        System.out.println(max(root));
//        System.out.println(height(root));
        traversals(root);
    }

}
