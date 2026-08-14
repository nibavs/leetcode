package com.leetcode.practice._977_Squares_of_a_Sorted_Array;

public class Solution {
    public int[] sortedSquares(int[] nums) {
        if (nums.length == 0) return nums;

        int[] res = new int[nums.length];

        int left = 0;
        int right = nums.length - 1;

        for (int i = res.length - 1; i >= 0; i--) {
            int l = nums[left] * nums[left];
            int r = nums[right] * nums[right];
            if (l > r) {
                res[i] = l;
                left++;
            } else {
                res[i] = r;
                right--;
            }
        }
        return res;
    }
}
