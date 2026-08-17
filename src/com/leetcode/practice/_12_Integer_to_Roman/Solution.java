package com.leetcode.practice._12_Integer_to_Roman;

public class Solution {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strings = {"M", "CM", "D", "DC", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while(num > values[i]) {
                num -= values[i];
                res.append(strings[i]);
            }
        }
        return res.toString();
    }
}
