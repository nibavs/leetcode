package com.leetcode.practice._724_Find_Pivot_Index;

public class Solution {
    public static int pivotIndex(int[] nums) {
        int[] prefSum = new int[nums.length];
        prefSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefSum[i] = prefSum[i - 1] + nums[i];
        }

        for (int i = 1; i < nums.length - 1; i++) {
            long leftSideSum = prefSum[i] - nums[i];
            long rightSideSum = prefSum[prefSum.length - 1] - prefSum[i];
            if (leftSideSum == rightSideSum) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }
}
