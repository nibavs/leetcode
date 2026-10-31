package com.leetcode.practice._118_Pascals_Triangle;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> firstRow = List.of(1);
        res.add(firstRow);

        rec(numRows - 1, firstRow, res);

        return res;
    }

    private void rec(int rowsLeft, List<Integer> prevRow, List<List<Integer>> res) {
        if (rowsLeft == 0) return;
        rowsLeft--;

        List<Integer> currentRow = new ArrayList<>();
        currentRow.add(1);

        for(int i = 0; i < prevRow.size() - 1; i++) {
            currentRow.add(prevRow.get(i) + prevRow.get(i + 1));
        }

        currentRow.add(1);

        res.add(currentRow);

        rec(rowsLeft, currentRow, res);
    }
}
