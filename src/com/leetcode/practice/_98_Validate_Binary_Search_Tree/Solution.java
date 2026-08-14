package com.leetcode.practice._98_Validate_Binary_Search_Tree;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val <= minVal || root.val >= maxVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

    public boolean isValidBSTDFS(TreeNode root) {
        if (root == null) return true;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;

        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (pre != null && root.val <= pre.val) {
                return false;
            }
            pre = root;
            root = root.right;
        }

        return true;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
//        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
