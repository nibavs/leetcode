package com.leetcode.practice._733_Flood_Fill;


import java.util.*;

public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initColor = image[sr][sc];
        if (initColor == color) return image;
        floodFillRec(image, sr, sc, color, initColor);
        return image;
    }

    private void floodFillRec(int[][] image, int sr, int sc, int color, int initColor) {
        if (sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length && image[sr][sc] == initColor) {
            image[sr][sc] = color;
            floodFillRec(image, sr + 1, sc, color, initColor);
            floodFillRec(image, sr - 1, sc, color, initColor);
            floodFillRec(image, sr, sc + 1, color, initColor);
            floodFillRec(image, sr, sc - 1, color, initColor);
        }
    }


    public int[][] floodFillIterative(int[][] image, int sr, int sc, int color) {
        int initColor = image[sr][sc];
        if (initColor == color) return image;

        Queue<List<Integer>> queue = new ArrayDeque<>();
        queue.offer(List.of(sr, sc));

        while (!queue.isEmpty()) {
            List<Integer> current = queue.poll();

            int i = current.get(0);
            int j = current.get(1);

            if (i >= 0 && i < image.length && j >= 0 && j < image[0].length && image[i][j] == initColor) {
                image[i][j] = color;
                queue.offer(List.of(i + 1, j));
                queue.offer(List.of(i - 1, j));
                queue.offer(List.of(i, j + 1));
                queue.offer(List.of(i, j - 1));
            }
        }
        return image;
    }



}
