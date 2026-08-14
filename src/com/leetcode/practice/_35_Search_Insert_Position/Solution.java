package com.leetcode.practice._35_Search_Insert_Position;


public class Solution {
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 2));
    }
}
