package com.leetcode.practice._303_Range_Sum_Query;

class NumArray {
    private int[] sums;

    // -2, 0, 3, -5, 2, -1
    // 0, -2, -2, 1, -4, -2, -3

    public NumArray(int[] nums) {
        // if (nums == null) throw

        sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        if (sums == null) return 0;
        if (right < left) return 0;
        return sums[right + 1] - sums[left];
    }
}
