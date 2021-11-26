package com.company;

public class LeetCode283_Advanced {
    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 13, 17, 22, 25, 60, 70, 78, 90, 100};

        int insertPosition = 0;
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] > 25) {
                if (i > insertPosition) {
                    int temp = arr[i];
                    arr[i] = arr[insertPosition];
                    arr[insertPosition] = temp;
//                }
                    insertPosition++;
                }
            }
        }  //60 70 78 90 100 123 346 1 3 6 13 17 22 25
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
