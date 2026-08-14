package com.leetcode.practice._213_House_Robber_II;

import java.util.Arrays;

public class Solution {
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        return Math.max(rec(nums, 0, nums.length - 1), rec(nums, 1, nums.length));
    }

    private static int rec(int[] nums, int start, int end) {
        int prevPrev = 0;
        int prev = 0;
        for (int i = start; i < end; i++) {
            int cur = Math.max(prev, prevPrev + nums[i]);
            prevPrev = prev;
            prev = cur;
        }

        return prev;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1};
        System.out.println(rob(nums));
    }
}
