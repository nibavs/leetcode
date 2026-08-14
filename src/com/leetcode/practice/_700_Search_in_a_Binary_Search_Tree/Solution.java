package com.leetcode.practice._700_Search_in_a_Binary_Search_Tree;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}

        TreeNode(int x) { val = x; }

    }
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        TreeNode rec = null;
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            rec = searchBST(root.left, val);
        } else {
            rec = searchBST(root.right, val);
        }
        return rec;
    }
}
