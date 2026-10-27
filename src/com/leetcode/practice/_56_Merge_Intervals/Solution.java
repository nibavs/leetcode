package com.leetcode.practice._56_Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= prev[1]) {
                prev[1] = Math.max(prev[1], intervals[i][1]);
            } else {
                merged.add(prev);
                prev = intervals[i];
            }
        }

        merged.add(prev);
        return merged.toArray(new int[merged.size()][]);
    }
}
