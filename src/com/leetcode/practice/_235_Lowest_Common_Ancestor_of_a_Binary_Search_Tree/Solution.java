package com.leetcode.practice._235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}

        TreeNode(int x) { val = x; }

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        TreeNode rec;
        if (p.val < root.val && q.val < root.val) {
            rec = lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            rec = lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
        return rec;
    }

    private void rec(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return;
        rec(root.left, p, q);
        rec(root.right, p, q);

    }
}
