package com.leetcode.practice._75_Sort_Colors;

public class Solution {
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        for (int i = 0; i <= end; i++) {
            if (nums[i] == 0) {
                swap(i, start++, nums);
            } else if (nums[i] == 2) {
                swap(i--, end--, nums);
            }
        }
    }

    private void swap(int i , int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
