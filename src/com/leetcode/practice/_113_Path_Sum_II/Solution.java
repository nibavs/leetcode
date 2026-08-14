package com.leetcode.practice._113_Path_Sum_II;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int x) {
            val = x;
        }

    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        dfs(root, targetSum, new ArrayList<>(), ans);
        return ans;
    }

    private static void dfs(TreeNode root, int targetSum, List<Integer> tempList, List<List<Integer>> ans) {
        tempList.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val) {
            ans.add(new ArrayList<>(tempList));
            return;
        }
        if (root.left != null) {
            dfs(root.left, targetSum - root.val, tempList, ans);
            tempList.remove(tempList.size() - 1);
        }
        if (root.right != null) {
            dfs(root.right, targetSum - root.val, tempList, ans);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static List<List<Integer>> pathSumIter(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        Deque<TreeNode> nodes = new ArrayDeque<>();
        Deque<Integer> sums = new ArrayDeque<>();
        Deque<List<Integer>> paths = new ArrayDeque<>();

        nodes.push(root);
        sums.push(root.val);
        paths.push(new ArrayList<>(List.of(root.val)));

        while(!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            int sum = sums.pop();
            List<Integer> path = paths.pop();

            if (node.left == null && node.right == null && sum == targetSum) {
                ans.add(path);
            }

            if (node.left != null) {
                nodes.push(node.left);
                sums.push(sum + node.left.val);
                List<Integer> p = new ArrayList<>(path);
                p.add(node.right.val);
                paths.push(p);
            }

            if (node.right != null) {
                nodes.push(node.right);
                sums.push(sum + node.right.val);
                List<Integer> p = new ArrayList<>(path);
                p.add(node.right.val);
                paths.push(p);
            }


        }
        return ans;
    }



    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
        TreeNode root = new TreeNode(0);
        TreeNode temp = root;
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
//        temp.left = new TreeNode(4);
//        temp.right = new TreeNode(8);
//
//        temp = temp.left;
//        temp.left = new TreeNode(11);
//        temp = temp.left;
//        temp.left = new TreeNode(7);
//        temp.right = new TreeNode(2);
//
//        temp = root.right;
//        temp.left = new TreeNode(13);
//        temp.right = new TreeNode(4);
//        temp = temp.right;
//        temp.left = new TreeNode(5);
//        temp.right = new TreeNode(1);


        System.out.println(pathSum(root, 1));
    }
}
