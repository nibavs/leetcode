package com.leetcode.practice._450_Delete_Node_in_a_BST;

import com.TreeNode;

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val == key) {
            if (root.left != null) {
                if (root.right == null) return root.left;
                TreeNode node = root;

                node = node.right;
                while (node.left != null) {
                    node = node.left;
                }
                node.left = root.left;
            }
            return root.right;

        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}
