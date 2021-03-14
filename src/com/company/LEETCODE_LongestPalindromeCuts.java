package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class LEETCODE_LongestPalindromeCuts {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        int ans = minCut(s);
        System.out.println("Min Cuts " + ans);
    }
    static int[][] panMap;
    static int[] map;

    public static int minCut(String s) {
        panMap = new int[s.length()][s.length()];
        map = new int[s.length() + 1];
        Arrays.fill(map, Integer.MAX_VALUE);
        map[s.length()] = 0;
        return minCut(s, 0) - 1;
    }

    private static int minCut(String s, int start) {
        if (map[start] != Integer.MAX_VALUE) return map[start];
        for (int i = start; i < s.length(); i++) {
            if (isPan(s, start, i)) {
                map[start] = Math.min(map[start], 1 + minCut(s, i + 1));
            }
        }
        return map[start];
    }
    private static boolean isPan(String s, int start, int end) {
        if (start == end) return true;
        if (start == end - 1 && s.charAt(start) == s.charAt(end))
            return true;
        if (panMap[start][end] != 0)
            return panMap[start][end] == 1;

        if (s.charAt(start) == s.charAt(end)) {
            panMap[start][end] = isPan(s, start + 1, end - 1) ? 1 : -1;
        }
        return panMap[start][end] == 1;
    }
}
