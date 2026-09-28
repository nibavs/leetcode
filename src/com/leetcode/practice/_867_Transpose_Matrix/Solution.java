package com.leetcode.practice._867_Transpose_Matrix;

import java.util.Arrays;

public class Solution {
    public static int[][] transpose(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return matrix;

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] res = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[j][i] = matrix[i][j];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6}};
        System.out.println(Arrays.deepToString(transpose(matrix)));
    }
}
