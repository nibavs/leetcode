package com.leetcode.practice._66_Plus_One;

import java.util.Arrays;

public class Solution {
    public static int[] plusOne(int[] digits) {
        int i = digits.length - 1;

        while (digits[i] == 9) {
            digits[i] = 0;
            i--;
            if (i < 0) {
                int[] newArr = new int[digits.length + 1];
                newArr[0] = 1;
                return newArr;
            }
        }
        digits[i] += 1;
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[] {9, 9, 9})));
    }
}
