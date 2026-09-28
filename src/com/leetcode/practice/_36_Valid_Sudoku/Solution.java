package com.leetcode.practice._36_Valid_Sudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> numbers = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[j][i] != '.') {
                    String s = "(" + board[i][j] + ")";
                    if (!numbers.add(i + s) || !numbers.add(s + j) || !numbers.add(i/3 + s + j/3)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
