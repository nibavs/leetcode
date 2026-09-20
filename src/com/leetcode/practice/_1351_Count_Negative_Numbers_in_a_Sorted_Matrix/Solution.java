package com.leetcode.practice._1351_Count_Negative_Numbers_in_a_Sorted_Matrix;

public class Solution {
    public int countNegatives(int[][] grid) {
        int amount = 0;
        for (int i = 0; i < grid.length; i++) {
            amount += grid[0].length - binarySearch(grid[i]);
        }

        return amount;
    }

    public static int countNegativesStaircase(int[][] grid) {
        // [[4,3,2,-1],
        //  [3,2,1,-1],
        //  [1,1,-1,-2],
        //  [-1,-1,-2,-3]]
        int n = grid.length;
        int m = grid[0].length;
        int i = n - 1;
        int j = 0;

        int amount = 0;
        while (i >= 0 && j < m) {
            if (grid[i][j] < 0) {
                amount += m - j;
                i--;
            } else {
                j++;
            }
        }

        return amount;
    }

    public static void main(String[] args) {
    }

    private int binarySearch(int[] row) {
        int left = 0;
        int right = row.length - 1;

        while (left <= right) {
            int mid = left + (right - left) /2;

            if (row[mid] >= 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right + 1;
    }
}
