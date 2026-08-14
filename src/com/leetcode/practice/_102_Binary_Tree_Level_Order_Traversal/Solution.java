package com.leetcode.practice._102_Binary_Tree_Level_Order_Traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}

        TreeNode(int x) { val = x; }

    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            List<Integer> ins = new ArrayList<>();
            int qs = queue.size();
            for (int i = 0; i < qs; i++) {
                root = queue.remove();
                ins.add(root.val);
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            ans.add(ins);
        }
        return ans;
    }

    public static List<List<Integer>> levelOrderRec(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        helper(root, 0, ans);

        return ans;
    }

    private static void helper(TreeNode root, int h, List<List<Integer>> ans) {
        if (ans.size() == h) {
            ans.add(new ArrayList<>());
        }
        ans.get(h).add(root.val);

        if (root.left != null) {
            helper(root.left, h + 1, ans);
        }

        if (root.right != null) {
            helper(root.right, h + 1, ans);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(levelOrder(root));
    }
}
