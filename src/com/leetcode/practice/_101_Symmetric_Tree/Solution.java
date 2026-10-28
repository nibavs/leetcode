package com.leetcode.practice._101_Symmetric_Tree;

import com.TreeNode;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricRec(root.left, root.right);
    }

    private boolean isSymmetricRec(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;

        if (left == null || right == null || left.val != right.val) return false;

        return isSymmetricRec(left.left, right.right) && isSymmetricRec(left.right, right.left);
    }
}
