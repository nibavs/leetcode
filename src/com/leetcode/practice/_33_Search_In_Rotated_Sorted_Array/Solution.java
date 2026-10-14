package com.leetcode.practice._33_Search_In_Rotated_Sorted_Array;

public class Solution {
    public int search(int[] nums, int target) {
        // [4,5,6,-1,0,1,2]
        // [0,1,2,4,5,6,7]
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            // left sorted
            if (nums[mid] > nums[right]) {
                if (nums[mid] > target && target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // right sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
