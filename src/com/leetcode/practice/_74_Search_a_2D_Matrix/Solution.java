package com.leetcode.practice._74_Search_a_2D_Matrix;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int top = 0;
        int bottom = matrix.length - 1;
        int targetRowIndex = -1;

        while (bottom <= top) {
            int mid = top + (bottom - top) / 2;

            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                if (mid == matrix.length - 1 || matrix[mid + 1][0] > target) {
                    targetRowIndex = mid;
                    break;
                } else {
                    bottom = mid + 1;
                }
            } else {
                top = mid - 1;
            }
        }

        if (targetRowIndex == -1) return false;

        int left = 0;
        int right = matrix[targetRowIndex].length - 1;


        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (matrix[targetRowIndex][mid] == target) {
                return true;
            } else if (matrix[targetRowIndex][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}