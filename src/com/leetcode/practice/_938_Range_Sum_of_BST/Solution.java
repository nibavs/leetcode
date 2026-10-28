package com.leetcode.practice._938_Range_Sum_of_BST;

import com.TreeNode;

class Solution {
    private static int sum = 0;

    public static int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        int res = sum;
        sum = 0;
        return res;
    }

    private static void dfs(TreeNode root, int low, int high) {
        if (root == null) return;

        dfs(root.left, low, high);
        dfs(root.right, low, high);
        if (root.val >= low && root.val <= high) sum += root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(3),
                        new TreeNode(7)
                ),
                new TreeNode(15,
                        null,
                        new TreeNode(18)
                )
        );


        System.out.println(rangeSumBST(root, 7, 15));
    }
}
