package com.leetcode.practice._79_Word_Search;

public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null) return false;

        int m = board.length;
        int n = board[0].length;

        if (m*n < word.length()) return false;

        boolean[][] snap = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j, snap)) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int wordIndex, int i, int j, boolean[][] snap) {
        if (i < 0 || j < 0
                || i >= board.length || j >= board[0].length
                || snap[i][j] || word.charAt(wordIndex) != board[i][j]) {
            return false;
        }
        snap[i][j] = true;
        wordIndex++;

        if (wordIndex == word.length()) return true;

        boolean found = dfs(board, word, wordIndex, i + 1, j, snap)
                || dfs(board, word, wordIndex, i - 1, j, snap)
                || dfs(board, word, wordIndex, i, j + 1, snap)
                || dfs(board, word, wordIndex, i, j - 1, snap);

        snap[i][j] = false;
        return found;
    }
}
