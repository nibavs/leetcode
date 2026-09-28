package com.leetcode.practice._54_Spiral_Matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        List<Integer> spiral = new ArrayList<>();

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++)
                spiral.add(matrix[top][i]);
            top++;

            for (int j = top; j <= bottom; j++)
                spiral.add(matrix[j][right]);
            right--;

            if (top <= bottom) {
                for (int k = right; k >= left; k--)
                    spiral.add(matrix[bottom][k]);
                bottom--;
            }

            if (left <= right) {
                for (int l = bottom; l >= top; l--)
                    spiral.add(matrix[l][left]);
                left++;
            }
        }

        return spiral;
    }

    public int subarraySum(int[] nums, int k) {
        int total = 0;
        int prefSum = 0;

        Map<Integer, Integer> prefSumCounter = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            prefSum += nums[i];
            if (prefSumCounter.containsKey(k - prefSum)) {
                total += prefSumCounter.get(k - prefSum);
            }
            prefSumCounter.put(prefSum, prefSumCounter.getOrDefault(prefSum, 0) + 1);
        }

        return total;
    }
}
