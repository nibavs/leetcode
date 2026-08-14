package com.leetcode.practice._27_Remove_Element;

public class Solution {
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] == val && i < n) {
                nums[i] = nums[n - 1];
                n--;
            }
        }

        return n;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1};
        System.out.println(removeElement(nums, 1));
    }
}
