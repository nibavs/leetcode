package com.leetcode.practice._912_Sort_an_Array;

public class Solution {

    public int[] bubbleSortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) swap(nums, j, j+1);
            }
        }
        return nums;
    }

    public int[] insertionSortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int j = i - 1;

            while (j >= 0 && nums[j] > current) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = current;
        }

        return nums;
    }

    public int[] selectionSortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }

            swap(nums, i, minIndex);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
