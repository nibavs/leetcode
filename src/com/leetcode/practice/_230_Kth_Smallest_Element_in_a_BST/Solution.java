package com.leetcode.practice._230_Kth_Smallest_Element_in_a_BST;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            if (k != 0) {
                root = stack.pop();
                k--;
                if (k == 0) return root.val;
                root = root.right;
            }
        }
        return 0;
    }

    public int kthSmallestRec(TreeNode root, int k) {
        if (root == null) return 0;
        ArrayList<Integer> kthSmallest = new ArrayList<>();
        inorderTraversal(root, kthSmallest);
        return kthSmallest.get(k - 1);
    }

    private void inorderTraversal(TreeNode root, List<Integer> kthSmallest) {
        if (root == null) return;
        inorderTraversal(root.left, kthSmallest);
        kthSmallest.add(root.val);
        inorderTraversal(root.right, kthSmallest);
    }



    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 1, 2, 2, 3};
//        System.out.println(topKF(nums, 2));
    }
}
