package com.leetcode.practice._48_Rotate_Image;

import java.util.Arrays;

public class Solution {
    public static void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int n = matrix.length;

        reverse(matrix);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(matrix, i, j);
            }
        }
    }

    private static void reverse(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        while (top < bottom) {
            int[] temp = matrix[top];
            matrix[top++] = matrix[bottom];
            matrix[bottom--] = temp;
        }
    }

    private static void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
