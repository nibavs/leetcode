package com.leetcode.practice._200_Number_of_Islands;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j);
                }
            }
        }

        return numIslands;
    }


    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') return;

        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    public int numIslandsBFS(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        Queue<int[]> queue = new ArrayDeque<>();
        int numIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    queue.offer(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        int x = curr[0];
                        int y = curr[1];

                        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '0') continue;

                        grid[x][y] = '0';
                        queue.offer(new int[]{x + 1, y});
                        queue.offer(new int[]{x - 1, y});
                        queue.offer(new int[]{x, y + 1});
                        queue.offer(new int[]{x, y - 1});
                    }
                }
            }
        }

        return numIslands;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 5, 6};
//        System.out.println(searchInsert(nums, 2));
    }
}
