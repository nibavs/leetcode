package com.leetcode.practice._77_Combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (n < k || n < 1) throw new IllegalArgumentException();

        List<List<Integer>> res = new ArrayList<>();
        if (k == 0) return res;
        backtrack(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> currentList, int n, int k, int start) {
        if (currentList.size() == k) {
            res.add(new ArrayList<>(currentList));
            return;
        }


        for(int i = start; i <= n; i++) {
            currentList.add(i);
            backtrack(res, currentList, n, k, i + 1);
            currentList.remove(currentList.size() - 1);
        }
    }
}
