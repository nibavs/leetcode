package com.leetcode.practice._4_Median_of_Two_Sorted_Arrays;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        if (m + n == 0) {
            throw new IllegalArgumentException("Both arrays are empty");
        }

        int leftSize = (m + n + 1) / 2; // 4

        int low = 0; // 3
        int high = m; // 5
        // 1,3,4,7,8
        // 2,6,7,9
        while (low <= high) {
            int i = low + (high - low) / 2; // 2, 4
            int j = leftSize - i; // 2, 0

            int left1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1]; // 3
            int right1 = i == m ? Integer.MAX_VALUE : nums1[i]; // 4

            int left2 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1]; // 6
            int right2 = j == n ? Integer.MAX_VALUE : nums2[j]; // 7

            if (left1 <= right2 && left2 <= right1) {
                int maxLeft = Math.max(left1, left2);

                if ((m + n) % 2 != 0) {
                    return maxLeft;
                }

                int minRight = Math.min(right1, right2);
                return ((double) maxLeft + minRight) / 2;
            }

            if (left1 > right2) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }
        return 0;
    }
}
