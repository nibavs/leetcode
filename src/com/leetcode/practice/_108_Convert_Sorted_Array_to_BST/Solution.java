package com.leetcode.practice._108_Convert_Sorted_Array_to_BST;

import com.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return rec(nums, 0, nums.length - 1);
    }

    private TreeNode rec(int[] nums, int start, int end) { // 3, 4
        if (start > end) return null;
        if (start == end) return new TreeNode(nums[start]);

        int mid = start + (end - start) / 2; // 0
        return new TreeNode(nums[mid], rec(nums, start, mid - 1), rec(nums, mid + 1, end));
    }
}
