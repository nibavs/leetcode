package com.leetcode.practice._701_Insert_into_a_Binary_Search_Tree;

import com.TreeNode;

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        TreeNode res = root;
        if (root.val > val) {
            if (root.left == null) root.left = new TreeNode(val);
            else insertIntoBST(root.left, val);
        } else {
            if (root.right == null) root.right = new TreeNode(val);
            else insertIntoBST(root.right, val);
        }

        return res;
    }
}
