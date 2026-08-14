package com.leetcode.practice._88_Merge_Sorted_Array;

import java.util.Arrays;

public class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int endPointer = m + n - 1;
        for (int i = m - 1, j = n - 1; j >= 0;) {
            if (i >= 0 && nums1[i] >= nums2[j]) {
                nums1[endPointer--] = nums1[i--];
            } else {
                nums1[endPointer--] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2,3,0,0,0};
        int[] nums2 = new int[] {2,5,6};

        merge(nums1, 3, nums2, 3);

        System.out.println(Arrays.toString(nums1));
    }
}
