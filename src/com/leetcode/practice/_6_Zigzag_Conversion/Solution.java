package com.leetcode.practice._6_Zigzag_Conversion;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static String convert(String s, int numRows) {
        if (s == null || s.length() < 3 || numRows == 1) return s;

        StringBuilder[] matrix = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            matrix[i] = new StringBuilder();
        }

        int direction = 1;
        int currentRow = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            matrix[currentRow].append(ch);
            if (currentRow == 0) {
                direction = 1;
            } else if (currentRow == numRows - 1) {
                direction = -1;
            }
            currentRow += direction;
        }

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            res.append(matrix[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
    }
}
