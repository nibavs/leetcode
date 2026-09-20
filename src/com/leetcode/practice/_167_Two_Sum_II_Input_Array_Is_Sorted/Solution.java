package com.leetcode.practice._167_Two_Sum_II_Input_Array_Is_Sorted;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        for (int right = numbers.length - 1; right >= 0; right--) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
                right++;
            }
        }
        return new int[]{0};

    }
}
