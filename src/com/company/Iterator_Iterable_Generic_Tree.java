package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Iterator_Iterable_Generic_Tree {

    static class GenericTree implements Iterable<Integer>{
        Node root;
        GenericTree(Node node){
            this.root = node;
        }
        public Iterator<Integer> iterator() {
            return new GTPreorderIterator(root);
        }
    }

    public static class GTPreorderIterator implements Iterator<Integer>{
        Integer next_val;
        Stack<Pair> st;
        public GTPreorderIterator(Node node){
            st = new Stack<>();
            st.push(new Pair(node, -1));
            next();
        }
        public boolean hasNext() {
            return next_val != null;
        }
        public Integer next() {
            Integer fr = next_val;

            next_val = null;
            while(st.size() > 0){
                Pair top = st.peek();
                if(top.state == -1){
                    //
                    next_val = top.node.data;
                    top.state++;
                    break;
                } else if(top.state == top.node.children.size()){
                    //
                    st.pop();
                } else{
                    Pair cp = new Pair(top.node.children.get(top.state), -1);
                    st.push(cp);
                    top.state++;
                }
            }
            return fr;
        }
    }

    private static class Pair{
        Node node;
        int state;
        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static Node construct(int[] arr) {
        Node root = null;
        Stack<Node> st = new Stack<>();
        for (int j : arr) {
            if (j == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = j;
                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }
                st.push(t);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }
        Node root = construct(arr);
        GenericTree gt = new GenericTree(root);
        for(int val: gt){
            System.out.println(val);
        }
    }

}
