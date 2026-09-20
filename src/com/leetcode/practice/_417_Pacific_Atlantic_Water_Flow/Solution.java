package com.leetcode.practice._417_Pacific_Atlantic_Water_Flow;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int m;
    private int n;


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();

        if (heights == null || heights.length == 0) {
            return res;
        }

        m = heights.length;
        n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) dfs(heights, i, 0, pacific);
        for (int i = 0; i < n; i++) dfs(heights, 0, i, pacific);
        for (int i = 0; i < m; i++) dfs(heights, i, n - 1, atlantic);
        for (int i = 0; i < n; i++) dfs(heights, m - 1, i, atlantic);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) res.add(List.of(i, j));
            }
        }

        return res;
    }

    private void dfs(int[][] heights, int i, int j, boolean[][] visited) {
        if (visited[i][j]) return;
        visited[i][j] = true;

        for (int[] dir : dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];

            if (nextI < 0 || nextI >= m
                    || nextJ < 0 || nextJ >= n
                    || heights[nextI][nextJ] < heights[i][j]) continue;

            dfs(heights, nextI, nextJ, visited);
        }
    }


}
