package com.leetcode.practice._94_Binary_Tree_Inorder_Traversal;


import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> stack = new ArrayDeque<>();

        while(root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;

        }

        return res;
    }

    public List<Integer> inorderTraversalRec(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        inorderTrav(root, res);

        return res;
    }

    private void inorderTrav(TreeNode root, List<Integer> res) {
        if (root == null) return;

        inorderTrav(root.left, res);
        res.add(root.val);
        inorderTrav(root.right, res);
    }



    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
//        System.out.println(searchInsert(nums, 2));
    }
}
