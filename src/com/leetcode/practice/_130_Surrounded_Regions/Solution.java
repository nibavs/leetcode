package com.leetcode.practice._130_Surrounded_Regions;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Solution {
    public static void solve(char[][] board) {
        int cols = board.length;
        int rows = board[0].length;

        boolean[][] visited = new boolean[cols][rows];
        for (int i = 0; i < cols; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0, visited);
            }
            if (board[i][rows - 1] == 'O') {
                dfs(board, i, rows - 1, visited);
            }
        }

        for (int i = 0; i < rows; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i, visited);
            }
            if (board[cols - 1][i] == 'O') {
                dfs(board, cols - 1, i, visited);
            }
        }
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (!visited[i][j]) board[i][j] = 'X';
            }
        }
    }

    private static void dfs(char[][] board, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 'X' || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        dfs(board, i + 1, j, visited);
        dfs(board, i - 1, j, visited);
        dfs(board, i, j + 1, visited);
        dfs(board, i, j - 1, visited);
    }

    public static void main(String[] args) {
//        char[][] board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
//        solve(board);
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                sb.append(board[i][j]).append(',');
//            }
//            sb.append('\n');
//        }
//        System.out.println(sb);


    }





}


