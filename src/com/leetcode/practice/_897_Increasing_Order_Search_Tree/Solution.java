package com.leetcode.practice._897_Increasing_Order_Search_Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}

        TreeNode(int x) { val = x; }

    }
    private TreeNode prev;

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        TreeNode ans = new TreeNode();
        TreeNode prev = ans;
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            prev.right = new TreeNode(root.val);
            prev = prev.right;
            root = root.right;
        }
        return ans;
    }

    public TreeNode increasingBSTRec(TreeNode root) {
        TreeNode ans = new TreeNode();
        prev = ans;
        inorder(root);
        return ans.right;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        prev.right = new TreeNode(root.val);
        prev = prev.right;
        inorder(root.right);
    }

}
