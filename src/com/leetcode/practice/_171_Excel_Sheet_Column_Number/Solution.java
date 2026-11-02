package com.leetcode.practice._171_Excel_Sheet_Column_Number;

public class Solution {
    public static int titleToNumber(String columnTitle) {
        int ans = 0;

        for (int i = 0; i < columnTitle.length(); i++) {
            char currentChar = columnTitle.charAt(i);
            int currentNumber = currentChar - 'A' + 1;
            ans *= 26;
            ans += currentNumber;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }
}
