package com.leetcode.practice._111_Minimum_Depth_of_Binary_Tree;

import com.TreeNode;

public class Solution {
    private int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        minDepth = Integer.MAX_VALUE;
        rec(root, 0);
        return minDepth;
    }

    private void rec(TreeNode root, int depth) {
        depth++;
        if (depth >= minDepth) return;
        if (root == null) return;

        if (root.left == null && root.right == null) {
            minDepth = Math.min(minDepth, depth);
        }

        rec(root.left, depth);
        rec(root.right, depth);
    }
}
