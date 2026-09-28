package com.leetcode.practice._1572_Diagonal_Sum;

public class Solution {
    public int diagonalSum(int[][] mat) {
        if (mat == null || mat.length == 0) return 0;

        int diagonalSum = 0;

        for (int i = 0; i < mat.length; i++) {
            diagonalSum += mat[i][i];
        }

        for (int i = mat.length - 1, j = 0; i >= 0; i--,j++){
            if (i == j) continue;
            diagonalSum += mat[i][j];
        }

        return diagonalSum;
    }
}
