package com.leetcode.practice._67_Add_Binary;

public class Solution {
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int extraOne = 0;

        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 || extraOne > 0; i--, j--) {
            int sum = extraOne;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
            }

            sb.append(sum % 2);
            extraOne = sum / 2;
        }


        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }
}
