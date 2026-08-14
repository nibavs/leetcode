package com.leetcode.practice._26_Remove_Duplicates_from_Sorted_Array;

import java.util.Arrays;

public class Solution {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int left = 1;

        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[left - 1]) {
                nums[left] = nums[right];
                left++;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0,0,1,1,1,2,2,3,3,3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
