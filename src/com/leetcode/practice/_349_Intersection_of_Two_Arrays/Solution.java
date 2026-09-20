package com.leetcode.practice._349_Intersection_of_Two_Arrays;

import java.util.*;

public class Solution {
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];

        Set<Integer> set = new HashSet<>();
        int[] ans = new int[nums1.length];

        for (int i : nums1) {
            set.add(i);
        }

        int j = 0;
        for (int i : nums2) {
            if (set.contains(i)) {
                ans[j++] = i;
                set.remove(i);
            }
        }

        return Arrays.copyOf(ans, j);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
}
