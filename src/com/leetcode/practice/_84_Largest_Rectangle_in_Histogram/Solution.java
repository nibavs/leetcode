package com.leetcode.practice._84_Largest_Rectangle_in_Histogram;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    public static int largestRectangleArea(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int[] leftMin = new int[arr.length];
        int[] rightMin = new int[arr.length];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                leftMin[i] = -1;
            } else {
                leftMin[i] = stack.peek();
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(leftMin));
        stack.clear();

        for (int i = arr.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                rightMin[i] = arr.length;
            } else {
                rightMin[i] = stack.peek();
            }

            stack.push(i);
        }


        System.out.println(Arrays.toString(rightMin));

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int width = rightMin[i] - leftMin[i] - 1;
            max = Math.max(max, width * arr[i]);
        }

        return max;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,1};
        System.out.println(largestRectangleArea(nums));
    }
}
