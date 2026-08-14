package com.leetcode.practice._62_Unique_Path;

import java.util.Arrays;

public class Solution {
    public int uniquePaths(int m, int n) {
        int[] aboveRow = new int[m];
        Arrays.fill(aboveRow, 1);

        for (int i = 1; i < n; i++) {
            int[] currentRow = new int[m];
            Arrays.fill(currentRow, 1);
            for (int j = 1; j < m; j++) {
                currentRow[j] = currentRow[j - 1] + aboveRow[j];
            }
            aboveRow = currentRow;
        }
        return aboveRow[m - 1];
    }
}
