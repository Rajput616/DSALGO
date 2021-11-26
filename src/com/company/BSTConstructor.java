package com.company;
import java.util.*;

public class BSTConstructor {
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

    public static class Pair{
        Node node;
        int state;

        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(int[] arr, int lo, int hi){
        if(lo > hi){
            return null;
        }
        int mid = (lo + hi)/2;
        int data = arr[mid];
        Node left = construct(arr, lo, mid-1);
        Node right = construct(arr, mid+1, hi);
        return new Node(data, left, right);
    }

    public static void display(Node node){
        if(node == null){
            return;
        }
        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";

        System.out.println(str);
        display(node.left);
        display(node.right);
    }

    public static void traversal(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.data + " in preorder");
        traversal(node.left);
        System.out.println(node.data + " in inorder");
        traversal(node.right);
        System.out.println(node.data + " in postorder");
    }

    public static void main(String[] args) throws Exception{
        int[] arr = {12, 25, 37, 50, 62, 75, 87};
        Node root = construct(arr, 0, arr.length-1);
        display(root);
//        traversal(root);
    }


}
