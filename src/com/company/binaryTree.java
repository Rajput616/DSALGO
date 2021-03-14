package com.company;
import java.util.*;

public class binaryTree {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data , Node left , Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static class Pair {
        Node node;
        int state;
        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }
    public static Node construct(Integer[] arr){
        Node root = new Node(arr[0] , null, null);
        Pair rtp = new Pair(root , 1);

        Stack<Pair> st = new Stack<> ();
        st.push(rtp);

        int idx = 0;
        while(st.size() > 0){
            Pair top = st.peek();
            if(top.state == 1){
                idx++;
                if(arr[idx] != null){
                    top.node.left = new Node(arr[idx] , null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if(top.state == 2){
                idx++;
                if(arr[idx] != null){
                    top.node.right = new Node(arr[idx] , null, null);
                    Pair rp = new Pair(top.node.right , 1);
                    st.push(rp);
                } else{
                    top.node.right = null;
                }
                top.state++;
            } else{
                st.pop();
            }
        }
        return root;
    }
    public static int size(Node node){
        if(node == null){
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }
    public static int sum(Node node){
        if(node == null){
            return 0;
        }
        return node.data + sum(node.left) + sum(node.right);
    }
    public static int max(Node node){
        if(node == null){
            return Integer.MIN_VALUE;
        }
        int lmx = max(node.left);
        int rmx = max(node.right);
        return Math.max(node.data , Math.max(lmx, rmx));
    }
    public static int height(Node node){
        if(node == null){
            return -1;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        return 1 + Math.max(lh , rh);
    }


    public static void display(Node node){
        if(node == null){
            return;
        }
        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += "<-" + node.data + "->";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println (str);

        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) throws Exception{
        Integer[] arr = {50, 25,12, null,null,37, 30, null, null,
                null, 75, 62,null, 70, null,null , 87, null , null };
        Node root = construct(arr);
        display (root);
        int size = size(root);
        int sum = sum(root);
        int max = max(root);
        int ht = height(root);
        System.out.println (size);
        System.out.println (sum);
        System.out.println (max);
        System.out.println (ht);
    }
}
