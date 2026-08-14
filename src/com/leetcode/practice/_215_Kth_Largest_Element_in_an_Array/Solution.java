package com.leetcode.practice._215_Kth_Largest_Element_in_an_Array;

import java.util.PriorityQueue;

public class Solution {

    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return 0;
        PriorityQueue<Integer> nms = new PriorityQueue<>();

        for (int n : nums) {
            nms.offer(n);
            if (nms.size() > k) nms.poll();
        }
        return nms.peek();
    }

    public static void main(String[] args) {
        int[] n = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(n, 4));
    }
}
