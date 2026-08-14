package com.leetcode.practice._104_Maximum_Depth_of_Binary_Tree;


import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Integer> depths = new ArrayDeque<>();

        stack.push(root);
        depths.push(1);

        int max = 1;
        while(!stack.isEmpty()) {
            root = stack.pop();
            int curDep = depths.pop();
            max = Math.max(max, curDep);
            if (root.left != null) {
                stack.push(root.left);
                depths.push(curDep + 1);
            }

            if (root.right != null) {
                stack.push(root.right);
                depths.push(curDep + 1);
            }
        }

        return max;
    }

    public int maxDepthRec(TreeNode root){
        if (root == null) return 0;
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        return Math.max(maxLeft, maxRight) + 1;
    }

}
