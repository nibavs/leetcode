package com.leetcode.practice._34_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

import java.util.Arrays;

class Solution {

    // 5 7 7 7 7 8 9
    public static int[] searchRange(int[] nums, int target) {
        // first, last
        int first = -1;
        int last = -1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != target) {
                    first = mid;
                    break;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (first == -1) return new int[]{first, last};

        left = 0;
        right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    last = mid;
                    break;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }


        return new int[]{first, last};

    }

    public static void main(String[] args) {

        int[] ints = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(ints, 8)));
    }
}
